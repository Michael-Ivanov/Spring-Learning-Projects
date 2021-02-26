package miv.study.thymeleafdemo.controller;

import miv.study.thymeleafdemo.dao.EmployeeRepository;
import miv.study.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
