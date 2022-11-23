package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BankOfficeRepository {
    private static BankOfficeRepository INSTANCE;

    private BankOfficeRepository() {
    }

    public static BankOfficeRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankOfficeRepository();
        }

        return INSTANCE;
    }

    private final ArrayList<BankOffice> bankOffices = new ArrayList<BankOffice>();


    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public BankOffice add(BankOffice bankOffice){
        if (bankOffice == null) {
            return null;
        }
        this.bankOffices.add(bankOffice);
        return bankOffice;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        for (BankOffice bankOffice:bankOffices) {
            if (bankOffice.getId() == id) {
                bankOffices.remove(bankOffice);
                return true;
            }
        }
        return false;
    }

    /*
     * Возвращает объект.
     */
    public BankOffice get(int id){
        for (BankOffice bankOffice:bankOffices) {
            if (bankOffice.getId() == id) {
                return bankOffice;
            }
        }
        return null;
    }

    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<BankOffice> findAll() {

        return this.bankOffices.stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public BankOffice update(BankOffice bankOffice) {

        if (bankOffice == null || !this.bankOffices.contains(bankOffice)) {
            return null;
        }

        this.bankOffices.set(this.bankOffices.indexOf(bankOffice), bankOffice);
        return get(bankOffice.getId());

    }
}
