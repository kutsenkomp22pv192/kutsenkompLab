package tech.reliab.course.kutsenkomp.bank.service.impl;

import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;
import tech.reliab.course.kutsenkomp.bank.repositories.BankOfficeRepository;
import tech.reliab.course.kutsenkomp.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    BankOfficeRepository bankOfficeRepository = new BankOfficeRepository();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public BankOffice add(BankOffice bankOffice) {
        if(bankOfficeRepository.add(bankOffice)){
            return bankOfficeRepository.get();
        }
        return null;
    }

    /*
     * Возвращает объект
     */
    @Override
    public BankOffice get() {
        return bankOfficeRepository.get();
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public boolean update(BankOffice bankOffice) {
        return bankOfficeRepository.update(bankOffice);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete() {
        return bankOfficeRepository.delete();
    }
}
