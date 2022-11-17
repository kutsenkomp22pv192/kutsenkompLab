package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;

import java.util.List;

public interface BankOfficeService {
    public BankOffice add(BankOffice bankOffice);
    public BankOffice get(int id);
    public BankOffice update(BankOffice bankOffice);
    public boolean delete(int id);
    List<BankOffice> getAll();
    boolean addEmployee(int bankOfficeId);
    boolean addAtm(int bankOfficeId, BankAtm bankAtm);
}
