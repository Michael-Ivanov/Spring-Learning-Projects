package miv.study.thymeleafdemo.controller;

import miv.study.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void createEmployeesList() {
        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@gmail.com");
        Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@gmail.com");
        Employee emp3 = new Employee(3, "Avani", "Gupta", "avani@gmail.com");

        employees = new ArrayList<>();

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
