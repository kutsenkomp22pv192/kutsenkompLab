package tech.reliab.course.kutsenkomp.bank.service.impl;


import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;
import tech.reliab.course.kutsenkomp.bank.repositories.BankRepository;
import tech.reliab.course.kutsenkomp.bank.repositories.CreditAccountRepository;
import tech.reliab.course.kutsenkomp.bank.service.CreditAccountService;

import java.util.List;

public class CreditAccountServiceImpl implements CreditAccountService {
    private static CreditAccountServiceImpl INSTANCE;

    private CreditAccountServiceImpl() {
    }

    public static CreditAccountServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CreditAccountServiceImpl();
        }

        return INSTANCE;
    }

    private final CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public CreditAccount add(CreditAccount creditAccount) {
        return creditAccountRepository.add(creditAccount);
    }

    /*
     * Возвращает объект
     */
    @Override
    public CreditAccount get(int id) {
        return creditAccountRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public CreditAccount update(CreditAccount creditAccount) {
        return creditAccountRepository.update(creditAccount);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return creditAccountRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<CreditAccount> getAll(){
        return creditAccountRepository.findAll();
    }
}
