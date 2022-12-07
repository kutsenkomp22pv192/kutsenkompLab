package tech.reliab.course.kutsenkomp.bank.service.impl;

import tech.reliab.course.kutsenkomp.bank.comparators.*;
import tech.reliab.course.kutsenkomp.bank.entity.*;
import tech.reliab.course.kutsenkomp.bank.exceptions.LendingTermsException;
import tech.reliab.course.kutsenkomp.bank.exceptions.NegativeSumException;
import tech.reliab.course.kutsenkomp.bank.exceptions.UserInputException;
import tech.reliab.course.kutsenkomp.bank.exceptions.ZeroMonthException;
import tech.reliab.course.kutsenkomp.bank.repositories.*;
import tech.reliab.course.kutsenkomp.bank.service.AtmService;
import tech.reliab.course.kutsenkomp.bank.service.BankService;
import tech.reliab.course.kutsenkomp.bank.service.CreditAccountService;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BankServiceImpl implements BankService {

    private static BankServiceImpl INSTANCE;

    private BankServiceImpl() {
    }

    public static BankServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankServiceImpl();
        }

        return INSTANCE;
    }

    private final BankRepository bankRepository = BankRepository.getInstance();


    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public Bank add(Bank bank) {
        return bankRepository.add(bank);
    }

    /*
     * Возвращает объект
     */
    @Override
    public Bank get(int id) {
        return bankRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public Bank update(int idBank, Bank bank) {
        return bankRepository.update(idBank, bank);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return bankRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    /*
     * Вывод банков
     */
    @Override
    public void outputBankInfo(int idBank, OutputStream outputStream) {

        PrintStream printStream = new PrintStream(outputStream);

        var bank = bankRepository.get(idBank);
        printStream.printf("Bank info %s\n", bank.getName());
        printStream.println(bank);

        BankOfficeRepository bankOfficeRepository = BankOfficeRepository.getInstance();
        BankAtmRepository bankAtmRepository = BankAtmRepository.getInstance();
        EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
        UserRepository userRepository = UserRepository.getInstance();

        var bankOffices = bankOfficeRepository.findAll().stream()
                .filter(bankOffice -> bankOffice.getBank().getId() == idBank)
                .toList();


        if (bankOffices.size() > 0) {
            printStream.println("Bank offices:");
            bankOffices.forEach(printStream::println);
        } else {
            printStream.println("Bank does not have offices");
        }

        var bankAtms = bankAtmRepository.findAll().stream()
                .filter(bankAtm -> bankAtm.getBankOffice().getBank().getId() == idBank)
                .toList();

        if (bankAtms.size() > 0) {
            printStream.println("Bank ATMs:");
            bankAtms.forEach(printStream::println);
        } else {
            printStream.println("Bank does not ATM");
        }

        var employees = employeeRepository.findAll().stream()
                .filter(employee -> employee.getBankOffice().getBank().getId() == idBank)
                .toList();

        if (employees.size() > 0) {
            printStream.println("Bank employees:");
            employees.forEach(printStream::println);
        } else {
            printStream.println("Bank does not employees");
        }

        var users = userRepository.findAll().stream()
                .filter(user -> user.getBanks().stream().filter(b -> b.getId() == idBank).toList().size() > 0)
                .toList();

        if (users.size() > 0) {
            printStream.println("Bank users:");
            users.forEach(printStream::println);
        } else {
            printStream.println("Bank does not user");
        }
    }

    /*
     * Выдача кредита
     */
    @Override
    public int issueCredit(OutputStream outputStream) throws LendingTermsException {
        PrintStream printStream = new PrintStream(outputStream);
        Scanner input = new Scanner(System.in);

        int userId = choseUserForCredit(printStream, input);

        System.out.print("Input credit sum: ");
        int creditSum = input.nextInt();

        System.out.print("Input count Month: ");
        int countMonth = input.nextInt();

        if(creditSum <=  0){
            throw new NegativeSumException();
        }
        if(countMonth <=  0){
            throw new ZeroMonthException();
        }


        int choseBankID = choseBankForCredit(printStream, input, userId);

        int choseOfficeID = choseBankOfficeForCredit(choseBankID, printStream, input, creditSum);

        int choseEmployeeID = choseEmployeeForCredit(choseOfficeID, printStream, input);

        int choseAtmID = choseBankAtmForCredit(choseOfficeID, printStream, input, creditSum);

        int creditAccountId = applyCredit(printStream, input,userId, choseBankID, choseEmployeeID, choseAtmID, creditSum, countMonth);

        return creditAccountId;
    }

    /*
     * Выбор пользователем банка
     */
    @Override
    public int choseBankForCredit(PrintStream printStream, Scanner input, int userId) throws LendingTermsException {
        var banks = new ArrayList<>(bankRepository.findAll().stream().sorted(new BankComparator()).toList());
        var user = UserServiceImpl.getInstance().get(userId);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        System.out.println("Enter the bank Id from those presented on the screen. Banks are listed in order from highest to lowest.");
        for (int i = 0; i < banks.size(); i++){
            printStream.printf("Bank id %s, Bank name %s, Bank rate %s, Bank interest rate %s\n", banks.get(i).getId(), banks.get(i).getName(), banks.get(i).getRate(), banks.get(i).getInterestRate());
            ids.add(banks.get(i).getId());
        }

        if (ids.isEmpty())
            throw new LendingTermsException();

        System.out.print("Input id: ");
        int choseBankID = input.nextInt();

        if (!ids.contains(choseBankID))
            throw new UserInputException();

        if(BankServiceImpl.getInstance().get(choseBankID).getRate() > 50 && user.getRate() < 500)
            throw new LendingTermsException();

        return choseBankID;

    }

    /*
     * Выбор пользователем оффиса
     */
    @Override
    public int choseBankOfficeForCredit(int idBank, PrintStream printStream, Scanner input, float creditSum) throws LendingTermsException {
        var offices = BankOfficeServiceImpl.getInstance().getAllBankOfficesByBankId(idBank);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        System.out.println("Enter the office id  from those that issue credit for a given amount:");
        for (int i = 0; i < offices.size(); i++){
            if (offices.get(i).getStatus() == "Working" && offices.get(i).getCanGiveCredit() && offices.get(i).getMoney() >= creditSum) {
                printStream.printf("Office id %s, Office name %s, Office address %s\n", offices.get(i).getId(), offices.get(i).getName(), offices.get(i).getAddress());
                ids.add(offices.get(i).getId());
            }
        }
        if (ids.isEmpty())
            throw new LendingTermsException();

        System.out.print("Input id: ");
        int choseOfficeID = input.nextInt();

        if (!ids.contains(choseOfficeID))
            throw new UserInputException();

        return choseOfficeID;
    }

    /*
     * Выбор пользователем сотрудника
     */
    @Override
    public int choseEmployeeForCredit(int idOffice, PrintStream printStream, Scanner input) throws LendingTermsException {
        var  employees= EmployeeServiceImpl.getInstance().getAllEmployeeByBankOfficeId(idOffice);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        System.out.println("Enter employee id from those that issue credit:");
        for (int i = 0; i < employees.size(); i++){
            if (employees.get(i).getCanGiveCredit()) {
                printStream.printf("Employee id %s, Employee name %s, Employee address %s\n", employees.get(i).getId(), employees.get(i).getFullName(), employees.get(i).getPosition());
                ids.add(employees.get(i).getId());
            }
        }
        if (ids.isEmpty())
            throw new LendingTermsException();

        System.out.print("Input id: ");
        int choseEmployeeID = input.nextInt();

        if (!ids.contains(choseEmployeeID))
            throw new UserInputException();

        return choseEmployeeID;
    }

    /*
     * Выбор пользователем банкомат
     */
    @Override
    public int choseBankAtmForCredit(int idOffice, PrintStream printStream, Scanner input, float creditSum) throws LendingTermsException {
        var atms= AtmServiceImpl.getInstance().getAllAtmByBankOfficeId(idOffice);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        System.out.println("Enter ATM id from those that issue credit:");
        for (int i = 0; i < atms.size(); i++){
            if (atms.get(i).getCanGiveMoney() && atms.get(i).getMoney() >= creditSum) {
                printStream.printf("Atm id %s, Atm name %s\n", atms.get(i).getId(), atms.get(i).getName());
                ids.add(atms.get(i).getId());
            }
        }
        if (ids.isEmpty())
            throw new LendingTermsException();

        System.out.print("Input id: ");
        int choseAtmID =input.nextInt();

        if (!ids.contains(choseAtmID))
            throw new UserInputException();

        return choseAtmID;
    }

    /*
     * Оформление кредита.
     * В случае, если у клиента нет платежного счета в этом банке, он создается.
     */
    @Override
    public int applyCredit(PrintStream printStream, Scanner input, int userId, int idBank, int idEmployee,int idAtm, float creditSum, int countMonth) throws LendingTermsException {
        var user = UserServiceImpl.getInstance().get(userId);
        Bank bank = BankServiceImpl.getInstance().get(idBank);
        Employee employee = EmployeeServiceImpl.getInstance().get(idEmployee);
        var paymentAccounts= PaymentAccountServiceImpl.getInstance().getAllPaymentAccountByUserId(userId);
        int chosePaymentAccountID = 0;
        ArrayList<Integer> ids = new ArrayList<Integer>();
        System.out.println("Enter id payment account:");
        for (int i = 0; i < paymentAccounts.size(); i++){
            if (paymentAccounts.get(i).getBankName().compareTo(bank.getName()) == 0) {
                printStream.printf("PaymentAccount id %s, Money %s\n", paymentAccounts.get(i).getId(), paymentAccounts.get(i).getMoney());
                ids.add(paymentAccounts.get(i).getId());
            }
        }
        if (ids.isEmpty()){
            System.out.print("You do not have a payment account with us in the bank, but we will open one!\n");
            chosePaymentAccountID = PaymentAccountServiceImpl.getInstance().getAll().size();
            PaymentAccountServiceImpl.getInstance().add(new PaymentAccount(chosePaymentAccountID, user, bank.getName(), 0));
            System.out.print("Payment account successfully created! Your payment account: \n");
            printStream.printf("PaymentAccount id %s, Money %s\n", PaymentAccountServiceImpl.getInstance().get(chosePaymentAccountID).getId(), PaymentAccountServiceImpl.getInstance().get(chosePaymentAccountID).getMoney());
        }
        else{
            System.out.print("Input id: ");
            chosePaymentAccountID = input.nextInt();

            if (!ids.contains(chosePaymentAccountID))
                throw new UserInputException();
        }

        PaymentAccount paymentAccount = PaymentAccountServiceImpl.getInstance().get(chosePaymentAccountID);
        int creditAccountId = CreditAccountServiceImpl.getInstance().getAll().size();
        CreditAccountServiceImpl.getInstance().add(new CreditAccount(creditAccountId, user, bank.getName(), creditSum, new Date(), countMonth, bank.getInterestRate(), employee, paymentAccount));
        AtmServiceImpl.getInstance().get(idAtm).setMoney(AtmServiceImpl.getInstance().get(idAtm).getMoney()-creditSum);
        AtmServiceImpl.getInstance().update(idAtm,AtmServiceImpl.getInstance().get(idAtm));
        bank.setMoney(bank.getMoney()-creditSum);
        BankServiceImpl.getInstance().update(idBank, bank);
        System.out.print("Credit account successfully created! Your credit account: \n");
        printStream.printf("CreditAccount id %s, Month Payment %s\n", CreditAccountServiceImpl.getInstance().get(creditAccountId).getId(),CreditAccountServiceImpl.getInstance().get(creditAccountId).getMonthPayment());
        return CreditAccountServiceImpl.getInstance().get(creditAccountId).getId();
    }

    @Override
    public int choseUserForCredit(PrintStream printStream, Scanner input) throws LendingTermsException {
        var users = UserServiceImpl.getInstance().getAll();


        ArrayList<Integer> ids = new ArrayList<Integer>();
        System.out.println("Enter the user Id.");
        for (int i = 0; i < users.size(); i++){
            printStream.printf("Bank id %s, Bank name %s\n", users.get(i).getId(), users.get(i).getFullName());
            ids.add(users.get(i).getId());
        }

        if (ids.isEmpty())
            throw new LendingTermsException();

        System.out.print("Input id: ");
        int userID = input.nextInt();

        if (!ids.contains(userID))
            throw new UserInputException();


        return userID;
    }
}

