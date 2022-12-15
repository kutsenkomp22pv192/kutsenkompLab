package tech.reliab.course.kutsenkomp.bank.service.impl;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
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
    public void saveToFilePaymentAccounts(String fileName, Bank bank, User user) throws IOException {
        PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();
        var paymentAccounts = paymentAccountRepository.findAll().stream()
                .filter(paymentAccount -> paymentAccount.getUser().getId() == user.getId() && paymentAccount.getBankName().compareTo(bank.getName()) == 0)
                .toList();

        try (JsonWriter writer = new JsonWriter(new FileWriter(fileName))) {
            gson.toJson(paymentAccounts, new TypeToken<ArrayList<PaymentAccount>>() {}.getType(), writer);
        }


    }

    @Override
    public void saveToFileCreditAccounts(String fileName, Bank bank, User user) throws IOException {
        CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();
        var creditAccounts = creditAccountRepository.findAll().stream()
                .filter(creditAccount -> creditAccount.getUser().getId() == user.getId() && creditAccount.getBankName().compareTo(bank.getName()) == 0)
                .toList();

        try (JsonWriter writer = new JsonWriter(new FileWriter(fileName))) {
            gson.toJson(creditAccounts, new TypeToken<ArrayList<CreditAccount>>() {}.getType(), writer);
        }

    }

    @Override
    public void transferPaymentAccounts(String fileName, Bank bank, PaymentAccount paymentAccount) throws IOException {

        try (JsonWriter writer = new JsonWriter(new FileWriter(fileName))) {
            gson.toJson(paymentAccount, new TypeToken<PaymentAccount>() {}.getType(), writer);
        }

        try (JsonReader reader = new JsonReader(new FileReader(fileName))) {
            PaymentAccount paymentAcc = gson.fromJson(reader, new TypeToken<PaymentAccount>() {
            }.getType());

            paymentAcc.setBankName(bank.getName());
            PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();
            paymentAccountRepository.update(paymentAcc);

        }

    }

    @Override
    public void transferCreditAccounts(String fileName, Bank bank, CreditAccount creditAccount) throws IOException {

        try (JsonWriter writer = new JsonWriter(new FileWriter(fileName))) {
            gson.toJson(creditAccount, new TypeToken<CreditAccount>() {}.getType(), writer);
        }

        try (JsonReader reader = new JsonReader(new FileReader(fileName))) {
            CreditAccount creditAcc = gson.fromJson(reader, new TypeToken<CreditAccount>() {
            }.getType());


            creditAcc.setBankName(bank.getName());
            CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();
            creditAccountRepository.update(creditAcc);

        }

    }








}

