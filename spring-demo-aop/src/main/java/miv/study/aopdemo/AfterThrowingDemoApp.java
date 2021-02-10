package miv.study.aopdemo;

import miv.study.aopdemo.config.DemoConfig;
import miv.study.aopdemo.dao.AccountDAO;
import miv.study.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the beans from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the account
        List<Account> accounts = null;
        try {
            // add a boolean flag to simulate exception
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Main program... caught exception: " + e);
        }

        // display the accounts
        System.out.println("Main program after throwing: " + accounts);

        // close the context
        context.close();
    }
}
