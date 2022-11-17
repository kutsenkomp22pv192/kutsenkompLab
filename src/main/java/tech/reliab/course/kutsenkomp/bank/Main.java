package tech.reliab.course.kutsenkomp.bank;

import tech.reliab.course.kutsenkomp.bank.entity.*;
import tech.reliab.course.kutsenkomp.bank.service.*;
import tech.reliab.course.kutsenkomp.bank.service.impl.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
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
            var bank = bankService.add(new Bank(idBank, "Bank_" + idBank, 0, 0, 0, 0,1, 0, 1 ));
            Employee employeeForAccount = null;
            for (int j = 0; j < officesNumber; j++) {
                int idBankOffice = i * banksNumber + j;
                var bankOffice = bankOfficeService.add(new BankOffice(bank, idBankOffice, "Office_" + idBankOffice, "Address_" + idBankOffice,"Working", true,  true,true, 0, true, 1, 1));
                Employee employee = null;
                for (int k = 0; k < employeeNumber; k++) {
                    int idEmployee = i * banksNumber + j * officesNumber + k;
                    employee = employeeService.add(new Employee(idEmployee, "FullName_" + idEmployee, sdf.parse("1988-02-" + idEmployee), "Pos_" + idEmployee, bank, true, bankOffice, true, 1));
                    if (employeeForAccount == null) {
                        employeeForAccount = employee;
                    }
                }
                atmService.add(new BankAtm(idBankOffice, "Atm_" + idBankOffice, "Address_" + idBankOffice, "Working", bank, bankOffice, employee, true,  true,1, 1));
            }
            for (int j = 0; j < usersNumber; j++) {
                int idUser = i * banksNumber + j;
                var user = userService.add(new User(idUser, "fullName_" + idUser, sdf.parse("1999-01-" + idUser),  "Address_" + idUser, 1, bank, 1));
                for (int k = 0; k < accountsNumber; k++) {
                    int idAccount = i * banksNumber + j * accountsNumber + k;
                    var paymentAccount = paymentAccountService.add(new PaymentAccount(idAccount, user, "Bank_" + i, 1));
                    var creditAccount = creditAccountService.add(new CreditAccount(idAccount, user, "Bank_" + i, 1, new Date(), 1, 1, 1, employeeForAccount, paymentAccount));
                }
            }
        }

        for (int i = 0; i < banksNumber; i++){
            bankService.outputBankInfo(bankService.getAll().get(i).getId(), System.out);
        }

        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < banksNumber * usersNumber; i++){
            userService.outputUserAccounts(userService.getAll().get(i).getId(), System.out);
        }

    }
}