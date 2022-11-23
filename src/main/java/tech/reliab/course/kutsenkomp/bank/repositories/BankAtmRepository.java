package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;
import tech.reliab.course.kutsenkomp.bank.entity.User;

import java.util.ArrayList;
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

    private final ArrayList<BankAtm> bankAtms = new ArrayList<BankAtm>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public BankAtm add(BankAtm bankAtm){
        if (bankAtm == null) {
            return null;
        }

        this.bankAtms.add(bankAtm);
        return bankAtm;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        for (BankAtm bankAtm:bankAtms) {
            if (bankAtm.getId() == id) {
                bankAtms.remove(bankAtm);
                return true;
            }
        }
        return false;
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

        return this.bankAtms.stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public BankAtm update(BankAtm bankAtm) {

        if (bankAtm == null || !this.bankAtms.contains(bankAtm)) {
            return null;
        }

        this.bankAtms.set(this.bankAtms.indexOf(bankAtm), bankAtm);
        return get(bankAtm.getId());

    }
}
