package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.BankOffice;
import tech.reliab.course.kutsenkomp.bank.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee add(Employee employee);
    public Employee get(int id);
    public Employee update(Employee employee);
    public boolean delete(int id);
    List<Employee> getAll();
    List<Employee> getAllEmployeeByBankOfficeId(int idBankOffice);
}
