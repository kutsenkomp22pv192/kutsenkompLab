package tech.reliab.course.kutsenkomp.bank.service.impl;


import tech.reliab.course.kutsenkomp.bank.entity.Employee;
import tech.reliab.course.kutsenkomp.bank.repositories.EmployeeRepository;
import tech.reliab.course.kutsenkomp.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    @Override
    public Employee add(Employee employee) {
        if(employeeRepository.add(employee)){
            return employeeRepository.get();
        }
        return null;
    }

    /*
     * Возвращает объект
     */
    @Override
    public Employee get() {
        return employeeRepository.get();
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    @Override
    public boolean update(Employee employee) {
        return employeeRepository.update(employee);
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    @Override
    public boolean delete() {
        return employeeRepository.delete();
    }
}
