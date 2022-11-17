package tech.reliab.course.kutsenkomp.bank.service.impl;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.PaymentAccount;
import tech.reliab.course.kutsenkomp.bank.repositories.*;
import tech.reliab.course.kutsenkomp.bank.service.BankService;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class BankServiceImpl implements BankService {

    private static BankServiceImpl INSTANCE;

    private BankServiceImpl() {
    }

    public static BankServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankServiceImpl();
        }

        return INSTANCE;
    }

    private final BankRepository bankRepository = BankRepository.getInstance();


    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public Bank add(Bank bank) {
        return bankRepository.add(bank);
    }

    /*
     * Возвращает объект
     */
    @Override
    public Bank get(int id) {
        return bankRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public Bank update(Bank bank) {
        return bankRepository.update(bank);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return bankRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<Bank> getAll(){
        return bankRepository.findAll();
    }

    /*
     * Вывод банков
     */
    @Override
    public void outputBankInfo(int idBank, OutputStream outputStream) {

        PrintStream printStream = new PrintStream(outputStream);

        var bank = bankRepository.get(idBank);
        printStream.printf("Bank info %s\n", bank.getName());
        printStream.println(bank);

        BankOfficeRepository bankOfficeRepository = BankOfficeRepository.getInstance();
        BankAtmRepository bankAtmRepository = BankAtmRepository.getInstance();
        EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
        UserRepository userRepository = UserRepository.getInstance();

        var bankOffices = bankOfficeRepository.findAll().stream()
                .filter(bankOffice -> bankOffice.getBank().getId() == idBank)
                .toList();


        if (bankOffices.size() > 0) {
            printStream.println("Bank offices:");
            bankOffices.forEach(printStream::println);
        } else {
            printStream.println("Bank does not have offices");
        }

        printStream.println("Bank does not office");

        var bankAtms = bankAtmRepository.findAll().stream()
                .filter(bankAtm -> bankAtm.getBankOffice().getBank().getId() == idBank)
                .toList();

        if (bankAtms.size() > 0) {
            printStream.println("Bank ATMs:");
            bankAtms.forEach(printStream::println);
        } else {
            printStream.println("Bank does not ATM");
        }

        var employees = employeeRepository.findAll().stream()
                .filter(employee -> employee.getBankOffice().getBank().getId() == idBank)
                .toList();

        if (employees.size() > 0) {
            printStream.println("Bank employees:");
            employees.forEach(printStream::println);
        } else {
            printStream.println("Bank does not employees");
        }

        var users = userRepository.findAll().stream()
                .filter(user -> user.getBanks().stream().filter(b -> b.getId() == idBank).toList().size() > 0)
                .toList();

        if (users.size() > 0) {
            printStream.println("Bank users:");
            users.forEach(printStream::println);
        } else {
            printStream.println("Bank does not user");
        }

    }
}
