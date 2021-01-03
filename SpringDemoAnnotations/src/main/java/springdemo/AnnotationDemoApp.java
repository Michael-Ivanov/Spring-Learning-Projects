package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springdemo.beans.Coach;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // read spring config
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        // close the context
        context.close();

    }
}
