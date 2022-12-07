package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaymentAccountRepository {
    private static PaymentAccountRepository INSTANCE;

    private PaymentAccountRepository() {
    }

    public static PaymentAccountRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PaymentAccountRepository();
        }

        return INSTANCE;
    }

    private final ArrayList<PaymentAccount> paymentAccounts = new ArrayList<PaymentAccount>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public PaymentAccount add(PaymentAccount paymentAccount){
        if (paymentAccount == null) {
            return null;
        }

        this.paymentAccounts.add(paymentAccount);
        return paymentAccount;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        for (PaymentAccount paymentAccount:paymentAccounts) {
            if (paymentAccount.getId() == id) {
                paymentAccounts.remove(paymentAccount);
                return true;
            }
        }
        return false;
    }

    /*
     * Возвращает объект.
     */
    public PaymentAccount get(int id){
        return this.paymentAccounts.get(id);
    }

    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<PaymentAccount> findAll() {

        return this.paymentAccounts.stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public PaymentAccount update(PaymentAccount paymentAccount) {

        if (paymentAccount == null || this.paymentAccounts.get(paymentAccount.getId()) == null) {
            return null;
        }


        for (PaymentAccount paymentAcc:paymentAccounts) {
            if (paymentAcc.getId() == paymentAccount.getId()) {
                this.paymentAccounts.set(this.paymentAccounts.indexOf(paymentAcc), paymentAccount);
            }
        }

        return get(paymentAccount.getId());

    }

}
