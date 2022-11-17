package tech.reliab.course.kutsenkomp.bank.service.impl;


import tech.reliab.course.kutsenkomp.bank.entity.Employee;
import tech.reliab.course.kutsenkomp.bank.repositories.EmployeeRepository;
import tech.reliab.course.kutsenkomp.bank.service.BankOfficeService;
import tech.reliab.course.kutsenkomp.bank.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeServiceImpl INSTANCE;

    private EmployeeServiceImpl() {
    }

    public static EmployeeServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeServiceImpl();
        }

        return INSTANCE;
    }

    private final EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
    private final BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public Employee add(Employee employee) {
        var newEmployee = employeeRepository.add(employee);
        var office = newEmployee.getBankOffice();

        if (office != null) {
            bankOfficeService.addEmployee(office.getId());
        }

        return newEmployee;
    }

    /*
     * Возвращает объект
     */
    @Override
    public Employee get(int id) {
        return employeeRepository.get(id);
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    /*
     * Возвращает лист объектов
     */
    @Override
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }


}
