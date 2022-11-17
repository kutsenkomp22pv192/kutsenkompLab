package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    private static EmployeeRepository INSTANCE;

    private EmployeeRepository() {
    }

    public static EmployeeRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeRepository();
        }

        return INSTANCE;
    }

    private final Map<Integer, Employee> employees = new LinkedHashMap<>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public Employee add(Employee employee){
        if (employee == null) {
            return null;
        }

        this.employees.put(employee.getId(), employee);
        return employee;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        if (!this.employees.containsKey(id)) {
            return false;
        }

        employees.remove(id);
        return true;
    }

    /*
     * Возвращает объект.
     */
    public Employee get(int id){
        return this.employees.get(id);
    }


    /*
     * Возвращает список объектов, которые хранятся в репозитории.
     */
    public List<Employee> findAll() {

        return this.employees.values().stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public Employee update(Employee employee) {

        if (employee == null || !this.employees.containsKey(employee.getId())) {
            return null;
        }

        this.employees.replace(employee.getId(), employee);
        return get(employee.getId());

    }
}
