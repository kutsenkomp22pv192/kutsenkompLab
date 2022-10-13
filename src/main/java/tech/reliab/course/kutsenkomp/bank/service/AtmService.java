package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;

public interface AtmService {
    public BankAtm add(BankAtm bankAtm);
    public BankAtm get();
    public boolean delete();
    public boolean update(BankAtm bankAtm);
}
