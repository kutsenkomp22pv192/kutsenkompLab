package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;

import java.io.OutputStream;
import java.util.List;

public interface BankService {
    public Bank add(Bank bank);
    public Bank get(int id);
    public Bank update(Bank bank);
    public boolean delete(int id);
    List<Bank> getAll();
    void outputBankInfo(int bankId, OutputStream outputStream);
}
