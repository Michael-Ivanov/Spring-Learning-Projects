package miv.study.aopdemo;

import miv.study.aopdemo.config.DemoConfig;
import miv.study.aopdemo.dao.AccountDAO;
import miv.study.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the beans from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business logic
        accountDAO.addAccount("Hello", "Hel");
        accountDAO.doWork();

        // call the accountDao getter/setter methods
        accountDAO.setName("foobar");
        accountDAO.setServiceName("silver");

        String name = accountDAO.getName();
        String serviceName = accountDAO.getServiceName();

        // close the context
        context.close();
    }
}
