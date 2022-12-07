package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static UserRepository INSTANCE;

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }

        return INSTANCE;
    }

    private final ArrayList<User> users = new ArrayList<User>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public User add(User user){
        if (user == null) {
            return null;
        }

        this.users.add(user);
        return user;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        for (User user:users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    /*
     * Возвращает объект.
     */
    public User get(int id){
        return this.users.get(id);
    }

    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<User> findAll() {

        return this.users.stream().toList().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public User update(User user) {

        if (user == null || !this.users.contains(user)) {
            return null;
        }
        this.users.set(this.users.indexOf(user), user);
        return get(user.getId());

    }


}
