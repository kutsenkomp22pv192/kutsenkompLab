package tech.reliab.course.kutsenkomp.bank.service.impl;


import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;
import tech.reliab.course.kutsenkomp.bank.repositories.PaymentAccountRepository;
import tech.reliab.course.kutsenkomp.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    PaymentAccountRepository paymentAccountRepository = new PaymentAccountRepository();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public PaymentAccount add(PaymentAccount paymentAccount) {
        if(paymentAccountRepository.add(paymentAccount)){
            return paymentAccountRepository.get();
        }
        return null;
    }

    /*
     * Возвращает объект
     */
    @Override
    public PaymentAccount get() {
        return paymentAccountRepository.get();
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public boolean update(PaymentAccount paymentAccount) {
        return paymentAccountRepository.update(paymentAccount);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete() {
        return paymentAccountRepository.delete();
    }
}
