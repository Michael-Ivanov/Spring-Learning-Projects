package miv.study.service;

import miv.study.entity.Customer;

import java.util.List;

public interface CustomerRestService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
