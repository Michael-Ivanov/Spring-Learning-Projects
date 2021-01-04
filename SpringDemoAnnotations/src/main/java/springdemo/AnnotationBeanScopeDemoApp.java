package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springdemo.beans.Coach;
import springdemo.beans.TennisCoach;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check it they are the same
        boolean result = (theCoach == alphaCoach);

        // print the result
        System.out.println("Pointing to the same object? " + result);

        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        // close the context
        context.close();
    }
}
