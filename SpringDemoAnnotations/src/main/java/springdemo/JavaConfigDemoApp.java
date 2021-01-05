package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.beans.Coach;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        // read spring config (java config source code)
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        // close the context
        context.close();

    }
}
