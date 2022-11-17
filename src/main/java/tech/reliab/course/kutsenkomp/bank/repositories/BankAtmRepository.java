package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BankAtmRepository {
    private static BankAtmRepository INSTANCE;

    private BankAtmRepository() {
    }

    public static BankAtmRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankAtmRepository();
        }

        return INSTANCE;
    }

    private final Map<Integer, BankAtm> bankAtms = new LinkedHashMap<>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public BankAtm add(BankAtm bankAtm){
        if (bankAtm == null) {
            return null;
        }

        this.bankAtms.put(bankAtm.getId(), bankAtm);
        return bankAtm;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        if (!this.bankAtms.containsKey(id)) {
            return false;
        }

        bankAtms.remove(id);
        return true;
    }
    /*
     * Возвращает объект.
     */
    public BankAtm get(int id){
        return this.bankAtms.get(id);
    }


    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<BankAtm> findAll() {

        return this.bankAtms.values().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public BankAtm update(BankAtm bankAtm) {

        if (bankAtm == null || !this.bankAtms.containsKey(bankAtm.getId())) {
            return null;
        }

        this.bankAtms.replace(bankAtm.getId(), bankAtm);
        return get(bankAtm.getId());

    }
}
