package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;

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

    private final Map<Integer, PaymentAccount> paymentAccounts = new LinkedHashMap<>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public PaymentAccount add(PaymentAccount paymentAccount){
        if (paymentAccount == null) {
            return null;
        }

        this.paymentAccounts.put(paymentAccount.getId(), paymentAccount);
        return paymentAccount;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        if (!this.paymentAccounts.containsKey(id)) {
            return false;
        }

        paymentAccounts.remove(id);
        return true;
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

        return this.paymentAccounts.values().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public PaymentAccount update(PaymentAccount paymentAccount) {

        if (paymentAccount == null || !this.paymentAccounts.containsKey(paymentAccount.getId())) {
            return null;
        }

        this.paymentAccounts.replace(paymentAccount.getId(), paymentAccount);
        return get(paymentAccount.getId());

    }

}
