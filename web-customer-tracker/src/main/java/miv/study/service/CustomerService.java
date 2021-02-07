package miv.study.service;

import miv.study.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    List<Customer> searchCustomers(String name);

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
