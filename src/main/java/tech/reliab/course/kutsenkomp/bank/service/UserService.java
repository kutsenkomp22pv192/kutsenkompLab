package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;
import tech.reliab.course.kutsenkomp.bank.entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface UserService {
    public User add(User user);
    public User get(int id);
    public User update(User user);
    public boolean delete(int id);
    List<User> getAll();
    void outputUserAccounts(int userId, OutputStream outputStream);

    void saveToFilePaymentAccounts(String fileName, Bank bank, User user) throws IOException;
    void saveToFileCreditAccounts(String fileName, Bank bank, User user) throws IOException;
    void transferPaymentAccounts(String fileName, int finalBankId, int paymentAccountId) throws IOException;
    void transferCreditAccounts(String fileName, int finalBankId, int creditAccountId) throws IOException;
}
