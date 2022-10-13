package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;

public interface BankService {
    public Bank add(Bank bank);
    public Bank get();
    public boolean update(Bank bank);
    public boolean delete();

}
