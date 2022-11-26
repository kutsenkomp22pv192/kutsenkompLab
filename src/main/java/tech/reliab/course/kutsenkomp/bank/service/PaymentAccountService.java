package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;
import tech.reliab.course.kutsenkomp.bank.entity.User;

import java.util.List;

public interface PaymentAccountService {
    public PaymentAccount add(PaymentAccount paymentAccount);
    public PaymentAccount get(int id);
    public PaymentAccount update(PaymentAccount paymentAccount);
    public boolean delete(int id);
    List<PaymentAccount> getAll();
    List<PaymentAccount> getAllPaymentAccountByUserId(int userId);
}
