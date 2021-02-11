package miv.study.aopdemo;

import miv.study.aopdemo.config.DemoConfig;
import miv.study.aopdemo.dao.AccountDAO;
import miv.study.aopdemo.entity.Account;
import miv.study.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the beans from spring container
        TrafficFortuneService trafficFortune =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main program: AroundDemoApp: " + trafficFortune.getFortune());
        System.out.println("Finished");
        // close the context
        context.close();
    }
}
