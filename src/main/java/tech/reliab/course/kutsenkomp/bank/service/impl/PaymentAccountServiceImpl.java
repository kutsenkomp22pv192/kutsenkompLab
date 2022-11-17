package tech.reliab.course.kutsenkomp.bank.service.impl;


import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;
import tech.reliab.course.kutsenkomp.bank.repositories.BankRepository;
import tech.reliab.course.kutsenkomp.bank.repositories.PaymentAccountRepository;
import tech.reliab.course.kutsenkomp.bank.service.PaymentAccountService;

import java.util.List;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private static PaymentAccountServiceImpl INSTANCE;

    private PaymentAccountServiceImpl() {
    }

    public static PaymentAccountServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PaymentAccountServiceImpl();
        }

        return INSTANCE;
    }

    private final PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public PaymentAccount add(PaymentAccount paymentAccount) {
        return paymentAccountRepository.add(paymentAccount);
    }

    /*
     * Возвращает объект
     */
    @Override
    public PaymentAccount get(int id) {
        return paymentAccountRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public PaymentAccount update(PaymentAccount paymentAccount) {
        return paymentAccountRepository.update(paymentAccount);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return paymentAccountRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<PaymentAccount> getAll(){
        return paymentAccountRepository.findAll();
    }
}
