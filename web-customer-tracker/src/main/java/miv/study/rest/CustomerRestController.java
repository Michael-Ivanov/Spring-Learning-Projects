package miv.study.rest;

import miv.study.entity.Customer;
import miv.study.exception.CustomerAlreadyExistsException;
import miv.study.exception.NoSuchCustomerException;
import miv.study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // add mapping for GET /customers/{id}
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new NoSuchCustomerException("No customer with id: " + id);
        }
        return customerService.getCustomer(id);
    }

    // add mapping for POST /customers to add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        if (alreadyExists(customer)) {
            throw new CustomerAlreadyExistsException("Customer already exists: " + customer);
        }
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    private boolean alreadyExists(Customer customer) {
        List<Customer> customerList = customerService.getCustomers();
        for (Customer tempCustomer : customerList) {
            if (tempCustomer.equals(customer)) {
                return true;
            }
        }
        return false;
    }
}
