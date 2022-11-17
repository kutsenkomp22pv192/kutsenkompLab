package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;

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

    private final Map<Integer, BankOffice> bankOffices = new LinkedHashMap<>();


    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public BankOffice add(BankOffice bankOffice){
        if (bankOffice == null) {
            return null;
        }
        this.bankOffices.put(bankOffice.getId(), bankOffice);
        return bankOffice;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        if (!this.bankOffices.containsKey(id)) {
            return false;
        }

        bankOffices.remove(id);
        return true;
    }

    /*
     * Возвращает объект.
     */
    public BankOffice get(int id){
        return this.bankOffices.get(id);
    }

    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<BankOffice> findAll() {

        return this.bankOffices.values().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public BankOffice update(BankOffice bankOffice) {

        if (bankOffice == null || !this.bankOffices.containsKey(bankOffice.getId())) {
            return null;
        }

        this.bankOffices.replace(bankOffice.getId(), bankOffice);
        return get(bankOffice.getId());

    }
}
