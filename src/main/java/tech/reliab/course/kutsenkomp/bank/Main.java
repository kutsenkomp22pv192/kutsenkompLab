package tech.reliab.course.kutsenkomp.bank;

import tech.reliab.course.kutsenkomp.bank.entity.*;
import tech.reliab.course.kutsenkomp.bank.service.*;
import tech.reliab.course.kutsenkomp.bank.service.impl.*;
import tech.reliab.course.kutsenkomp.bank.exceptions.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random RANDOM = new Random();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, CloneNotSupportedException {
        BankService bankService = BankServiceImpl.getInstance();
        AtmService atmService = AtmServiceImpl.getInstance();
        BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();
        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
        CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();
        PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        final int banksNumber = 5;
        final int officesNumber = 3;
        final int employeeNumber = 5;
        final int usersNumber = 5;
        final int accountsNumber = 2;

        for (int i = 0; i < banksNumber; i++) {
            int idBank = i;
            var bank = bankService.add(new Bank(idBank, "Bank_" + idBank, 0, 0, 0, 0,RANDOM.nextInt(100), 0));
            Employee employeeForAccount = null;
            for (int j = 0; j < officesNumber; j++) {
                int idBankOffice = i * officesNumber + j;
                var bankOffice = bankOfficeService.add(new BankOffice(bank, idBankOffice, "Office_" + idBankOffice, "Address_" + idBankOffice,"Working", true,  true,true, 0, true, RANDOM.nextInt(100000), RANDOM.nextInt(1000)));
                Employee employee = null;
                for (int k = 0; k < employeeNumber; k++) {
                    int idEmployee = i * officesNumber * employeeNumber + j * employeeNumber + k;
                    employee = employeeService.add(new Employee(idEmployee, "FullName_" + idEmployee, sdf.parse("1988-02-" + idEmployee), "Pos_" + idEmployee, bank, true, bankOffice, true, RANDOM.nextInt(10000)));
                    if (employeeForAccount == null) {
                        employeeForAccount = employee;
                    }
                }
                atmService.add(new BankAtm(idBankOffice, "Atm_" + idBankOffice, "Address_" + idBankOffice, "Working", bank, bankOffice, employee, true,  true,RANDOM.nextInt(100000), RANDOM.nextInt(1000)));
            }
            for (int j = 0; j < usersNumber; j++) {
                int idUser = i * usersNumber + j;
                var user = userService.add(new User(idUser, "fullName_" + idUser, sdf.parse("1999-01-" + idUser),  "Address_" + idUser, RANDOM.nextInt(100000), bank));
                for (int k = 0; k < accountsNumber; k++) {
                    int idAccount = i * usersNumber * accountsNumber + j * accountsNumber + k;
                    var paymentAccount = paymentAccountService.add(new PaymentAccount(idAccount, user, "Bank_" + i, RANDOM.nextInt(1000000)));
                    var creditAccount = creditAccountService.add(new CreditAccount(idAccount, user, "Bank_" + i, RANDOM.nextInt(1000), new Date(), 1, bank.getInterestRate(), employeeForAccount, paymentAccount));
                }
            }
        }



        try {
            userService.saveToFile("file.txt", bankService.getAll().get(0), userService.getAll().get(0));

            System.out.println("User before update:");
            userService.outputUserAccounts(userService.getAll().get(0).getId(), System.out);


            //В файле обозначен перенос двух счетов из банка 0 в банк 1 и в банк 2
            userService.updateFromFile("file2.txt", userService.getAll().get(0));

            System.out.println("\nUser after update:");
            userService.outputUserAccounts(userService.getAll().get(0).getId(), System.out);

        } catch (IOException e) {
            System.out.println("Ошибка файла: " + e);
        }
    }

}