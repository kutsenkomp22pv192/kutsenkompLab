package tech.reliab.course.kutsenkomp.bank.repositories;

import tech.reliab.course.kutsenkomp.bank.entity.Employee;

public class EmployeeRepository {
    private Employee employee;

    public EmployeeRepository(){}

    /*
     * Добавляет bank и возвращает добаленный объект, если до этого его не существовало
     * иначе возвращает null.
     */
    public boolean add(Employee employee){
        var isEmpty = this.employee == null;
        if (isEmpty){
            this.employee = new Employee(employee);
        }
        return isEmpty;
    }

    /*
     * Удаляет объект и возвращает истину, если объект существовал,
     * иначе возвращает ложь.
     */
    public boolean delete(){
        if(this.employee == null){
            return false;
        }
        this.employee = null;
        return true;
    }

    /*
     * Возвращает объект.
     */
    public Employee get(){
        return this.employee;
    }

    /*
     * Обновляет объект и возвращает истину, если он существует,
     * иначе возвращает ложь.
     */
    public boolean update(Employee employee){
        if(this.employee == null){
            return false;
        }
        this.employee = employee;
        return true;
    }
}
