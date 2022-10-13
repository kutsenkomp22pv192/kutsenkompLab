package tech.reliab.course.kutsenkomp.bank;

import tech.reliab.course.kutsenkomp.bank.entity.*;
import tech.reliab.course.kutsenkomp.bank.service.*;
import tech.reliab.course.kutsenkomp.bank.service.impl.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        AtmService atmService = new AtmServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        UserService userService = new UserServiceImpl();


        var bank = bankService.add(new Bank(1, "Bank_1", 0, 0, 0, 0,1, 1, 1 ));

        var bankOffice = bankOfficeService.add(new BankOffice(bank, 1, "Office_1", "Address_1","Status_1", true,  true,true, 0, true, 1, 1));

        var employee = employeeService.add(new Employee(1, "FullName_1", new Date(),
                "Pos_1", bank, true, bankOffice, true, 1));

        var atm = atmService.add(new BankAtm(1, "Atm_1", "Address_1",
                "Status_1", bank, bankOffice, employee, true,  true,1, 1));

        var user = userService.add(new User(1, "fullName_1", new Date(),  "Address_1",
                1, bank, 1));

        var paymentAccount = paymentAccountService.add(new PaymentAccount(1, user, "Bank_1", 1));

        var creditAccount = creditAccountService.add(new CreditAccount(1, user, "Bank_1", 1, new Date(), new Date(), 1, 1,
                1, employee, paymentAccount));


        System.out.println(bank);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(atm);
        System.out.println(user);
        System.out.println(creditAccount);
        System.out.println(paymentAccount);
    }
}