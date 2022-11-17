package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;
import tech.reliab.course.kutsenkomp.bank.entity.User;

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

    private final Map<Integer, User> users = new LinkedHashMap<>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public User add(User user){
        if (user == null) {
            return null;
        }

        this.users.put(user.getId(), user);
        return user;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        if (!this.users.containsKey(id)) {
            return false;
        }

        users.remove(id);
        return true;
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

        return this.users.values().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public User update(User user) {

        if (user == null || !this.users.containsKey(user.getId())) {
            return null;
        }

        this.users.replace(user.getId(), user);
        return get(user.getId());

    }
}
