package miv.study.controller;

import miv.study.entity.Customer;
import miv.study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        // get customer from the service
        List<Customer> customers = customerService.getCustomers();
        // add the customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // create model attribute to bind for data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        // get the customer from the service
        Customer customer = customerService.getCustomer(id);
        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        // send over to our form
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // save the customer using our service
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id, Model model) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/searchCustomer")
    public String searchCustomer(@RequestParam("searchName") String name, Model model) {
        // check for null or empty name
        if (name == null || name.isEmpty()) {
            return "redirect:/customer/list";
        }
        // get appropriate list of customers
        List<Customer> customers = customerService.searchCustomers(name);
        // add list of customers to the model
        model.addAttribute("customers", customers);
        return "list-customers";
    }
}
