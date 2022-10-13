package tech.reliab.course.kutsenkomp.bank.service.impl;


import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.repositories.CreditAccountRepository;
import tech.reliab.course.kutsenkomp.bank.service.CreditAccountService;

public class CreditAccountServiceImpl implements CreditAccountService {
    CreditAccountRepository creditAccountRepository = new CreditAccountRepository();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public CreditAccount add(CreditAccount creditAccount) {
        if(creditAccountRepository.add(creditAccount)){
            return creditAccountRepository.get();
        }
        return null;
    }

    /*
     * Возвращает объект
     */
    @Override
    public CreditAccount get() {
        return creditAccountRepository.get();
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public boolean update(CreditAccount creditAccount) {
        return creditAccountRepository.update(creditAccount);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete() {
        return creditAccountRepository.delete();
    }
}
