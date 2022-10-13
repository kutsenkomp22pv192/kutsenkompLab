package tech.reliab.course.kutsenkomp.bank.service.impl;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.repositories.BankRepository;
import tech.reliab.course.kutsenkomp.bank.service.BankService;

public class BankServiceImpl implements BankService {

    BankRepository bankRepository = new BankRepository();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public Bank add(Bank bank) {
        if(bankRepository.add(bank)){
            return bankRepository.get();
        }
        return null;
    }

    /*
     * Возвращает объект
     */
    @Override
    public Bank get() {
        return bankRepository.get();
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public boolean update(Bank bank) {
        return bankRepository.update(bank);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete() {
        return bankRepository.delete();
    }
}
