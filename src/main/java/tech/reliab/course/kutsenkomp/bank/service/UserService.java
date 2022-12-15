package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.*;

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
    void transferPaymentAccounts(String fileName, Bank bank, PaymentAccount paymentAccount) throws IOException;
    void transferCreditAccounts(String fileName, Bank bank, CreditAccount creditAccount) throws IOException;
}
