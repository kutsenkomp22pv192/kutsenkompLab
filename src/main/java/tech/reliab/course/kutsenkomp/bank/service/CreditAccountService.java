package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;

import java.util.List;

public interface CreditAccountService {
    public CreditAccount add(CreditAccount сreditAccount);
    public CreditAccount get(int id);
    public CreditAccount update(CreditAccount сreditAccount);
    public boolean delete(int id);
    List<CreditAccount> getAll();
}
