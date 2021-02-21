package miv.study.demo;

import miv.study.config.DemoAppConfig;
import miv.study.entity.Customer;
import miv.study.service.CustomerRestService;
import miv.study.service.CustomerRestServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);

        // get rest-service instance
        CustomerRestService service = context.getBean("customerRestServiceImpl", CustomerRestService.class);

        // get list of customers
        List<Customer> customers = service.getCustomers();
        System.out.println("Get customers: " + customers);

        // add new customer
        Customer customer = new Customer("John", "Malkovich", "jmalk@yandex.ru");
        System.out.println("Adding new customer:" + customer);
        service.saveCustomer(customer);
        System.out.println("Customer saved");
    }
}
