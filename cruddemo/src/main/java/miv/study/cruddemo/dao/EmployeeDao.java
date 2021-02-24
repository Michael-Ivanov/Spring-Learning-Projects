package miv.study.cruddemo.dao;

import miv.study.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void delete(int id);
}
