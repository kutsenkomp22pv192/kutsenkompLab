package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.User;

public class UserRepository {
    private User user;

    public UserRepository(){}

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public boolean add(User user){
        var isEmpty = this.user == null;
        if (isEmpty){
            this.user = new User(user);
        }
        return isEmpty;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(){
        if(this.user == null){
            return false;
        }
        this.user = null;
        return true;
    }

    /*
     * Возвращает объект.
     */
    public User get(){
        return this.user;
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    public boolean update(User user){
        if(this.user == null){
            return false;
        }
        this.user = user;
        return true;
    }
}
