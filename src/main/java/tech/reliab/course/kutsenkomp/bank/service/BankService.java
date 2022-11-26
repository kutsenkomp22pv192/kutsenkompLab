package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;
import tech.reliab.course.kutsenkomp.bank.entity.User;
import tech.reliab.course.kutsenkomp.bank.exceptions.*;
import tech.reliab.course.kutsenkomp.bank.service.impl.BankServiceImpl;

import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public interface BankService {
    public Bank add(Bank bank);
    public Bank get(int id);
    public Bank update(int idBank, Bank bank);
    public boolean delete(int id);
    List<Bank> getAll();
    void outputBankInfo(int bankId, OutputStream outputStream);
    int issueCredit(int userId, float creditSum, OutputStream outputStream, int countMonth) throws LendingTermsException;
    int choseBankForCredit(PrintStream printStream, Scanner input, int userId) throws LendingTermsException;
    int choseBankOfficeForCredit(int idBank, PrintStream printStream, Scanner input, float creditSum) throws LendingTermsException;
    int choseEmployeeForCredit(int idOffice, PrintStream printStream, Scanner input) throws LendingTermsException;
    int choseBankAtmForCredit(int idOffice, PrintStream printStream, Scanner input, float creditSum) throws LendingTermsException;
    int applyCredit(PrintStream printStream, Scanner input, int userId, int idBank, int idEmployee,int idAtm, float creditSum, int countMonth) throws LendingTermsException;

}
