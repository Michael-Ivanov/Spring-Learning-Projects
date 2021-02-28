package miv.study.thymeleafdemo.service;

import miv.study.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeesList(String sorting);

    Employee getEmployee(int id);

    void addEmployee(Employee employee);

    void deleteEmployee(int id);
}
