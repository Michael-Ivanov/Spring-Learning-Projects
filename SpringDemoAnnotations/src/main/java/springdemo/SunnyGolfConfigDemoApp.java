package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.beans.Coach;
import springdemo.config.SunnyGolfConfig;

public class SunnyGolfConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SunnyGolfConfig.class);

        Coach golfCoach = context.getBean("golfCoach", Coach.class);

        System.out.println(golfCoach.getDailyWorkout());

        System.out.println(golfCoach.getDailyFortune());

        context.close();
    }
}
