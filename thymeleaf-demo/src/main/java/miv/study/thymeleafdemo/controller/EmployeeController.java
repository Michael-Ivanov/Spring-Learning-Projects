package miv.study.thymeleafdemo.controller;

import miv.study.thymeleafdemo.entity.Employee;
import miv.study.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.getEmployeesSorted();
        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("newEmployee", new Employee());
        return "employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("ggg") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees/list";
    }
}
