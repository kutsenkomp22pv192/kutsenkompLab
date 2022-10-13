package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;

public interface BankOfficeService {
    public BankOffice add(BankOffice bankOffice);
    public BankOffice get();
    public boolean update(BankOffice bankOffice);
    public boolean delete();
}
