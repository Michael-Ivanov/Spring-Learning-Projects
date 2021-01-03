package miv.study.springdemo;

import miv.study.springdemo.beans.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Coach coach1 = context.getBean("myCoach", Coach.class);
        System.out.println(coach1.getDailyWorkout());
        System.out.println(coach1.getDailyFortune());
        System.out.println("-----------------------------------------");
        System.out.println("Let's create another coach..");
        Coach coach2 = context.getBean("myCoach", Coach.class);
        System.out.println("Coach2 obj class is " + coach2.getClass().getSimpleName());
        System.out.println("coach1 == coach2? " + (coach1 == coach2));


//        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
//        System.out.println(cricketCoach.getDailyWorkout());
//        System.out.println(cricketCoach.getDailyFortune());
//        System.out.println(cricketCoach.getClass().getSimpleName());
//        System.out.println(cricketCoach.getEmailAddress());
//        System.out.println(cricketCoach.getTeam());
//        System.out.println("---------------------------------------------");
    }
}
