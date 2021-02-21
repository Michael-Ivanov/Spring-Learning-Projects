package miv.study.demo;

import miv.study.config.DemoAppConfig;
import miv.study.entity.Customer;
import miv.study.service.CustomerRestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);

        CustomerRestService service = context.getBean(CustomerRestService.class);

        List<Customer> customers = service.getCustomers();

        System.out.println(customers);
    }
}
