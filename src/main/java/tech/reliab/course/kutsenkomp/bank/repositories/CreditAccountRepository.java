package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreditAccountRepository {
    private static CreditAccountRepository INSTANCE;

    private CreditAccountRepository() {
    }

    public static CreditAccountRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CreditAccountRepository();
        }

        return INSTANCE;
    }

    private final Map<Integer, CreditAccount> creditAccounts = new LinkedHashMap<>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public CreditAccount add(CreditAccount creditAccount){
        if (creditAccount == null) {
            return null;
        }

        this.creditAccounts.put(creditAccount.getId(), creditAccount);
        return creditAccount;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        if (!this.creditAccounts.containsKey(id)) {
            return false;
        }

        creditAccounts.remove(id);
        return true;
    }

    /*
     * Возвращает объект.
     */
    public CreditAccount get(int id){
        return this.creditAccounts.get(id);
    }


    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<CreditAccount> findAll() {

        return this.creditAccounts.values().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public CreditAccount update(CreditAccount creditAccount) {

        if (creditAccount == null || !this.creditAccounts.containsKey(creditAccount.getId())) {
            return null;
        }

        this.creditAccounts.replace(creditAccount.getId(), creditAccount);
        return get(creditAccount.getId());

    }
}
