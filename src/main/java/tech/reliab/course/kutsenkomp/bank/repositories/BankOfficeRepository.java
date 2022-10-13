package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;

public class BankOfficeRepository {
    private BankOffice bankOffice;

    public BankOfficeRepository(){}

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public boolean add(BankOffice bankOffice){
        var isEmpty = this.bankOffice == null;
        if (isEmpty){
            this.bankOffice = new BankOffice(bankOffice);
        }
        return isEmpty;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(){
        if(this.bankOffice == null){
            return false;
        }
        this.bankOffice = null;
        return true;
    }

    /*
     * Возвращает объект.
     */
    public BankOffice get(){
        return this.bankOffice;
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    public boolean update(BankOffice bankOffice){
        if(this.bankOffice == null){
            return false;
        }
        this.bankOffice = bankOffice;
        return true;
    }
}
