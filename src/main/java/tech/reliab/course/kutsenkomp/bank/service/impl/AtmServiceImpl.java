package tech.reliab.course.kutsenkomp.bank.service.impl;

import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.repositories.BankAtmRepository;
import tech.reliab.course.kutsenkomp.bank.service.AtmService;

public class AtmServiceImpl implements AtmService {
    BankAtmRepository bankAtmRepository = new BankAtmRepository();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public BankAtm add(BankAtm bankAtm) {
        if(bankAtmRepository.add(bankAtm)){
            return bankAtmRepository.get();
        }
        return null;
    }

    /*
     * Возвращает объект
     */
    @Override
    public BankAtm get() {
        return bankAtmRepository.get();
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public boolean update(BankAtm bankAtm) {
        return bankAtmRepository.update(bankAtm);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete() {
        return bankAtmRepository.delete();
    }
}
