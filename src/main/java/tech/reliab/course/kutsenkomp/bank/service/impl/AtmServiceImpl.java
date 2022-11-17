package tech.reliab.course.kutsenkomp.bank.service.impl;

import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;
import tech.reliab.course.kutsenkomp.bank.repositories.BankAtmRepository;
import tech.reliab.course.kutsenkomp.bank.repositories.BankOfficeRepository;
import tech.reliab.course.kutsenkomp.bank.service.AtmService;
import tech.reliab.course.kutsenkomp.bank.service.BankOfficeService;
import tech.reliab.course.kutsenkomp.bank.service.BankService;

import java.util.List;

public class AtmServiceImpl implements AtmService {
    private static AtmServiceImpl INSTANCE;

    private AtmServiceImpl() {
    }

    public static AtmServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AtmServiceImpl();
        }

        return INSTANCE;
    }

    private final BankService bankService = BankServiceImpl.getInstance();
    private final BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();
    private final BankAtmRepository bankAtmRepository = BankAtmRepository.getInstance();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public BankAtm add(BankAtm bankAtm) {

        var newBankAtm = bankAtmRepository.add(bankAtm);
        var office = newBankAtm.getBankOffice();

        if (office != null) {
            bankOfficeService.addAtm(office.getId(), bankAtm);
        }
        return newBankAtm;
    }

    /*
     * Возвращает объект
     */
    @Override
    public BankAtm get(int id) {
        return bankAtmRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public BankAtm update(BankAtm bankAtm) {
        return bankAtmRepository.update(bankAtm);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return bankAtmRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<BankAtm> getAll(){
        return bankAtmRepository.findAll();
    }
}
