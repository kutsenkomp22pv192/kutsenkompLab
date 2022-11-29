package tech.reliab.course.kutsenkomp.bank.service.impl;


import com.google.gson.Gson;
import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;
import tech.reliab.course.kutsenkomp.bank.entity.User;
import tech.reliab.course.kutsenkomp.bank.repositories.BankRepository;
import tech.reliab.course.kutsenkomp.bank.repositories.CreditAccountRepository;
import tech.reliab.course.kutsenkomp.bank.repositories.PaymentAccountRepository;
import tech.reliab.course.kutsenkomp.bank.repositories.UserRepository;
import tech.reliab.course.kutsenkomp.bank.service.UserService;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.util.Objects;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class UserServiceImpl implements UserService {
    Gson gson = new Gson();

    Type payAccArrType = new TypeToken<ArrayList<PaymentAccount>>() {}.getType();
    Type credAccArrType = new TypeToken<ArrayList<CreditAccount>>() {}.getType();

    private static UserServiceImpl INSTANCE;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserServiceImpl();
        }

        return INSTANCE;
    }

    private final UserRepository userRepository = UserRepository.getInstance();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public User add(User user) {
        return userRepository.add(user);
    }

    /*
     * Возвращает объект
     */
    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /*
     * Вывод пользователей
     */
    @Override
    public void outputUserAccounts(int userId, OutputStream outputStream) {

        PrintStream printStream = new PrintStream(outputStream);
        var user = userRepository.get(userId);
        printStream.printf("User info %s\n", user.getFullName());
        printStream.println(user);

        PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();
        CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();
        var paymentAccounts = paymentAccountRepository.findAll().stream()
                .filter(paymentAccount -> paymentAccount.getUser().getId() == userId)
                .toList();
        if (paymentAccounts.size() > 0) {
            printStream.println("Payment accounts:");
            paymentAccounts.forEach(printStream::println);
        } else {
            printStream.println("User does not have payment accounts");
        }

        var creditAccounts = creditAccountRepository.findAll().stream()
                .filter(creditAccount -> creditAccount.getUser().getId() == userId)
                .toList();

        if (creditAccounts.size() > 0) {
            printStream.println("Credit accounts:");
            creditAccounts.forEach(printStream::println);
        } else {
            printStream.println("User does not have credit accounts");
        }

    }

    @Override
    public void saveToFile(String fileName, Bank bank, User user) throws IOException {
        PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();
        CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();
        var paymentAccounts = paymentAccountRepository.findAll().stream()
                .filter(paymentAccount -> paymentAccount.getUser().getId() == user.getId() && paymentAccount.getBankName().compareTo(bank.getName()) == 0)
                .toList();
        var creditAccounts = creditAccountRepository.findAll().stream()
                .filter(creditAccount -> creditAccount.getUser().getId() == user.getId() && creditAccount.getBankName().compareTo(bank.getName()) == 0)
                .toList();
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        writer.write("Payment Accounts:\n" + gson.toJson(paymentAccounts)  + "\n\nCredit Accounts:\n" + gson.toJson(creditAccounts));
        writer.close();
    }

    @Override
    public void updateFromFile(String fileName, User user) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        boolean first = true;
        while (line != null) {
            if (!line.isEmpty()) {
                if (line.charAt(0) == '[') {
                    if (first) {
                        first = false;
                        this.makePayAccFromJson(gson.fromJson(line, new TypeToken<ArrayList<PaymentAccount>>(){}.getType()),user);
                    }
                    else {
                        this.makeCreditAccFromJson(gson.fromJson(line, credAccArrType),user);
                    }
                }
            }
            line = reader.readLine();
        }
    }

    private void makePayAccFromJson(ArrayList<PaymentAccount> jsonPayAcc, User user) {
        PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();
        var paymentAccounts = paymentAccountRepository.findAll().stream()
                .filter(paymentAccount -> paymentAccount.getUser().getId() == user.getId())
                .toList();

        if (!jsonPayAcc.isEmpty()) {
            for (int i = 0; i < paymentAccounts.size(); i++) {
                for (int j = 0; j < paymentAccounts.size(); j++) {
                    if (paymentAccounts.get(i).getId() == jsonPayAcc.get(j).getId()) {
                        String nameNew = jsonPayAcc.get(j).getBankName();
                        String nameOld = paymentAccounts.get(i).getBankName();

                        paymentAccounts.get(i).setBankName(jsonPayAcc.get(j).getBankName());


                        BankRepository bankRepository = BankRepository.getInstance();
                        var bankOld = bankRepository.findAll().stream()
                                .filter(bk -> bk.getName().compareTo(nameOld) == 0).toList();
                        var bankNew = bankRepository.findAll().stream()
                                .filter(bk -> bk.getName().compareTo(nameNew) == 0).toList();
                        ArrayList<Bank> banks = user.getBanks();
                        banks.remove(bankOld.get(0));
                        banks.add(bankNew.get(0));
                        UserRepository userRepository = UserRepository.getInstance();
                        user.setBanks(banks);
                        userRepository.update(user);
                    }
                }
            }
        }
    }

    private void makeCreditAccFromJson(ArrayList<CreditAccount> jsonPayAcc, User user) {
        CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();
        var creditAccounts = creditAccountRepository.findAll().stream()
                .filter(creditAccount -> creditAccount.getUser().getId() == user.getId())
                .toList();

        if (!jsonPayAcc.isEmpty()) {
            for (int i = 0; i < creditAccounts.size(); i++) {
                for (int j = 0; j < creditAccounts.size(); j++) {
                    if (creditAccounts.get(i).getId() == jsonPayAcc.get(j).getId()) {
                        creditAccounts.get(i).setBankName(jsonPayAcc.get(j).getBankName());
                    }
                }
            }
        }
    }



}

