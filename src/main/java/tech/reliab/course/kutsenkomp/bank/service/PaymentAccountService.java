package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;

public interface PaymentAccountService {
    public PaymentAccount add(PaymentAccount paymentAccount);
    public PaymentAccount get();
    public boolean update(PaymentAccount paymentAccount);
    public boolean delete();
}
