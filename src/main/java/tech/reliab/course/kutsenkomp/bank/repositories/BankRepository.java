package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.comparators.BankComparator;
import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;
import tech.reliab.course.kutsenkomp.bank.service.impl.BankOfficeServiceImpl;

import java.util.ArrayList;
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

    private final ArrayList<Bank> banks = new ArrayList<Bank>();


    /*
     * Добавляет bank и возвращает добаленный объект
     */
    public Bank add(Bank bank){
        if (bank == null) {
            return null;
        }

        this.banks.add(bank);
        return bank;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        for (Bank bank:banks) {
            if (bank.getId() == id) {
                banks.remove(bank);
                return true;
            }
        }
        return false;
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

        return this.banks.stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public Bank update(int idBank, Bank bank) {
        this.banks.set(idBank, bank);
        return get(bank.getId());

    }
}
