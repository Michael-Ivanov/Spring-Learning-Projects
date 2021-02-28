package miv.study.thymeleafdemo.service;

import miv.study.thymeleafdemo.dao.EmployeeRepository;
import miv.study.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployeesList(String sorting) {
        // todo: think how to refactor this piece of ...
        List<Employee> list;
        if (sorting == null) {
            list = employeeRepository.findAll();
        } else if (sorting.equals("first-name")) {
            list = employeeRepository.findAllByOrderByFirstNameAsc();
        } else if (sorting.equals("last-name")) {
            list = employeeRepository.findAllByOrderByLastNameAsc();
        } else if (sorting.equals("email")) {
            list = employeeRepository.findAllByOrderByEmailAsc();
        } else {
            list = employeeRepository.findAll();
        }
        return list;
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Employee id not found: " + id));
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
