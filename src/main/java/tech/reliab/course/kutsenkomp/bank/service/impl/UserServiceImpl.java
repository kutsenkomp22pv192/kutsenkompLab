package tech.reliab.course.kutsenkomp.bank.service.impl;


import tech.reliab.course.kutsenkomp.bank.entity.User;
import tech.reliab.course.kutsenkomp.bank.repositories.UserRepository;
import tech.reliab.course.kutsenkomp.bank.service.UserService;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepository();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public User add(User user) {
        if(userRepository.add(user)){
            return userRepository.get();
        }
        return null;
    }

    /*
     * Возвращает объект
     */
    @Override
    public User get() {
        return userRepository.get();
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete() {
        return userRepository.delete();
    }
}
