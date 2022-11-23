package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;
import tech.reliab.course.kutsenkomp.bank.entity.BankAtm;
import tech.reliab.course.kutsenkomp.bank.entity.CreditAccount;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;

import java.util.ArrayList;
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

    private final ArrayList<Employee> employees = new ArrayList<Employee>();

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public Employee add(Employee employee){
        if (employee == null) {
            return null;
        }

        this.employees.add(employee);
        return employee;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(int id){
        for (Employee employee:employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
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

        return this.employees.stream().toList();

    }

    /*
     * Обновляет объект и возвращает его, если он существует,
     * иначе возвращает ложь.
     */
    public Employee update(Employee employee) {

        if (employee == null || !this.employees.contains(employee)) {
            return null;
        }

        this.employees.set(this.employees.indexOf(employee), employee);
        return get(employee.getId());

    }
}
