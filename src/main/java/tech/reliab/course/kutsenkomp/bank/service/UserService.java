package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;
import tech.reliab.course.kutsenkomp.bank.entity.User;

import java.io.OutputStream;
import java.util.List;

public interface UserService {
    public User add(User user);
    public User get(int id);
    public User update(User user);
    public boolean delete(int id);
    List<User> getAll();
    void outputUserAccounts(int userId, OutputStream outputStream);
}
