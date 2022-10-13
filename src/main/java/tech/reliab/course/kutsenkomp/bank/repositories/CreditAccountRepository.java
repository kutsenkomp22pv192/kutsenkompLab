package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;

public class CreditAccountRepository {
    private CreditAccount creditAccount;

    public CreditAccountRepository(){}

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public boolean add(CreditAccount user){
        var isEmpty = this.creditAccount == null;
        if (isEmpty){
            this.creditAccount = new CreditAccount(user);
        }
        return isEmpty;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(){
        if(this.creditAccount == null){
            return false;
        }
        this.creditAccount = null;
        return true;
    }

    /*
     * Возвращает объект.
     */
    public CreditAccount get(){
        return this.creditAccount;
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    public boolean update(CreditAccount creditAccount){
        if(this.creditAccount == null){
            return false;
        }
        this.creditAccount = creditAccount;
        return true;
    }
}
