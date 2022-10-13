package tech.reliab.course.kutsenkomp.bank.service;

import tech.reliab.course.kutsenkomp.bank.entity.Employee;

public interface EmployeeService {
    public Employee add(Employee employee);
    public Employee get();
    public boolean update(Employee employee);
    public boolean delete();
}
