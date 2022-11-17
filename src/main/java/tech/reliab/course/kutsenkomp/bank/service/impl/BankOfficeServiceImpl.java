package tech.reliab.course.kutsenkomp.bank.service.impl;

import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;
import tech.reliab.course.kutsenkomp.bank.repositories.BankOfficeRepository;
import tech.reliab.course.kutsenkomp.bank.service.BankOfficeService;
import tech.reliab.course.kutsenkomp.bank.service.BankService;

import java.util.List;

public class BankOfficeServiceImpl implements BankOfficeService {
    private static BankOfficeServiceImpl INSTANCE;

    private BankOfficeServiceImpl() {
    }

    public static BankOfficeServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankOfficeServiceImpl();
        }

        return INSTANCE;
    }

    private final BankService bankService = BankServiceImpl.getInstance();
    private final BankOfficeRepository bankOfficeRepository = BankOfficeRepository.getInstance();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public BankOffice add(BankOffice bankOffice) {

        var newBankOffice = bankOfficeRepository.add(bankOffice);

        var bank = bankService.get(bankOffice.getBank().getId());

        if (bank != null) {
            bank.setMoney(bank.getMoney() + bankOffice.getMoney());
            bank.setCountOffices(bank.getCountOffices() + 1);
            bankService.update(bank);
        }

        return newBankOffice;
    }

    /*
     * Возвращает объект
     */
    @Override
    public BankOffice get(int id) {
        return bankOfficeRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public BankOffice update(BankOffice bankOffice) {
        return bankOfficeRepository.update(bankOffice);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return bankOfficeRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<BankOffice> getAll(){
        return bankOfficeRepository.findAll();
    }

    @Override
    public boolean addEmployee(int bankOfficeId) {

        var bankOffice = bankOfficeRepository.get(bankOfficeId);
        if (bankOffice == null) {
            return false;
        }
        var bank = bankService.get(bankOffice.getBank().getId());

        if (bank != null) {
            bank.setCountEmployees(bank.getCountEmployees() + 1);
            bankService.update(bank);
            return true;
        }

        return false;

    }

    @Override
    public boolean addAtm(int bankOfficeId, BankAtm bankAtm) {
        var bankOffice = bankOfficeRepository.get(bankOfficeId);
        if (bankOffice == null) {
            return false;
        }
        var bank = bankService.get(bankOffice.getBank().getId());

        if (bank != null) {
            bank.setMoney(bank.getMoney() + bankAtm.getMoney());

            bank.setCountAtm(bank.getCountAtm() + 1);
            bankService.update(bank);
            bankOffice.setCountAtm(bankOffice.getCountAtm() + 1);
            bankOfficeRepository.update(bankOffice);
            return true;
        }

        return false;
    }

}
