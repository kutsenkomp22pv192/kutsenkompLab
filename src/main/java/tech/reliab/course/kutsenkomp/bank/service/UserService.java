package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.User;

public interface UserService {
    public User add(User user);
    public User get();
    public boolean update(User user);
    public boolean delete();
}
