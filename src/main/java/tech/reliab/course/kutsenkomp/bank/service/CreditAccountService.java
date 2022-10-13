package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;

public interface CreditAccountService {
    public CreditAccount add(CreditAccount сreditAccount);
    public CreditAccount get();
    public boolean update(CreditAccount сreditAccount);
    public boolean delete();
}
