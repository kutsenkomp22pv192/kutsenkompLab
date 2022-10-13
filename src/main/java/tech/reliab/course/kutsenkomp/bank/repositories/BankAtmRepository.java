package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;

public class BankAtmRepository {
    private BankAtm bankAtm;

    public BankAtmRepository(){}

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public boolean add(BankAtm bankAtm){
        var isEmpty = this.bankAtm == null;
        if (isEmpty){
            this.bankAtm = new BankAtm(bankAtm);
        }
        return isEmpty;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(){
        if(this.bankAtm == null){
            return false;
        }
        this.bankAtm = null;
        return true;
    }

    /*
     * Возвращает объект.
     */
    public BankAtm get(){
        return this.bankAtm;
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    public boolean update(BankAtm bankAtm){
        if(this.bankAtm == null){
            return false;
        }
        this.bankAtm = bankAtm;
        return true;
    }
}
