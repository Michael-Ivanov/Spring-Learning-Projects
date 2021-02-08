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
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business logic
        accountDAO.addAccount();
        membershipDAO.addSomething();

        // close the context
        context.close();
    }
}
