package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;

import java.util.List;

public interface AtmService {
    public BankAtm add(BankAtm bankAtm);
    public BankAtm get(int id);
    public boolean delete(int id);
    public BankAtm update(int idBankAtm, BankAtm bankAtm);
    List<BankAtm> getAll();
    List<BankAtm> getAllAtmByBankOfficeId(int idBankAtm);
}
