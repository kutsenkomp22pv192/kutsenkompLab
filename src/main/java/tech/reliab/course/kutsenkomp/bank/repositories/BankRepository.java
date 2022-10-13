package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;

public class BankRepository {
    private Bank bank;

    public BankRepository(){}

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public boolean add(Bank bank){
        var isEmpty = this.bank == null;
        if (isEmpty){
            this.bank = new Bank(bank);
        }
        return isEmpty;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(){
        if(this.bank == null){
            return false;
        }
        this.bank = null;
        return true;
    }

    /*
     * Возвращает объект.
     */
    public Bank get(){
        return this.bank;
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    public boolean update(Bank bank){
        if(this.bank == null){
            return false;
        }
        this.bank = bank;
        return true;
    }

}
