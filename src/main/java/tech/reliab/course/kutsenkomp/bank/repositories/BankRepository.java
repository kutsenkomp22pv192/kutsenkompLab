package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {

    private static BankRepository INSTANCE;

    private BankRepository() {
    }

    public static BankRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankRepository();
        }

        return INSTANCE;
    }

    private final Map<Integer, Bank> banks = new LinkedHashMap<>();


    /*
     * Добавляет bank и возвращает добаленный объект
     */
    public Bank add(Bank bank){
        if (bank == null) {
            return null;
        }

        this.banks.put(bank.getId(), bank);
        return bank;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        if (!this.banks.containsKey(id)) {
            return false;
        }

        banks.remove(id);
        return true;
    }

    /*
     * Возвращает объект.
     */
    public Bank get(int id){
        return this.banks.get(id);
    }


    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<Bank> findAll() {

        return this.banks.values().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public Bank update(Bank bank) {

        if (bank == null || !this.banks.containsKey(bank.getId())) {
            return null;
        }

        this.banks.replace(bank.getId(), bank);
        return get(bank.getId());

    }
}
