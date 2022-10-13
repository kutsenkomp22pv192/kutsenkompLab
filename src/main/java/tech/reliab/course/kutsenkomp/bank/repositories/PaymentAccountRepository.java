package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;

public class PaymentAccountRepository {
    private PaymentAccount paymentAccount;

    public PaymentAccountRepository(){}

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public boolean add(PaymentAccount paymentAccount){
        var isEmpty = this.paymentAccount == null;
        if (isEmpty){
            this.paymentAccount = new PaymentAccount(paymentAccount);
        }
        return isEmpty;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(){
        if(this.paymentAccount == null){
            return false;
        }
        this.paymentAccount = null;
        return true;
    }

    /*
     * Возвращает объект.
     */
    public PaymentAccount get(){
        return this.paymentAccount;
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    public boolean update(PaymentAccount paymentAccount){
        if(this.paymentAccount == null){
            return false;
        }
        this.paymentAccount = paymentAccount;
        return true;
    }
}
