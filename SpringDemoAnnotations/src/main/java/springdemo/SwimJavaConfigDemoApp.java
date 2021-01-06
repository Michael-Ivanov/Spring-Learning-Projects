package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.beans.Coach;
import springdemo.beans.SwimCoach;
import springdemo.config.SportConfig;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        // read spring config (java config source code)
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        // creating another swimCoach

        Coach coach1 = context.getBean("swimCoach", Coach.class);

        // checking if they are the same object

        System.out.println("Are they the same object? " + (coach == coach1));

        System.out.println("email is: " + coach.getEmail());
        System.out.println("Team is: " + coach.getTeam());

        // close the context
        context.close();

    }
}
