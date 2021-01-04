package springdemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

   /* @Autowired
    public TennisCoach(@Qualifier("normFortuneService") FortuneService fortuneService) {
        System.out.println("Inside tennis coach constructor");
        this.fortuneService = fortuneService;
    }*/

    // define an init method
    @PostConstruct
    private void doMyStartupStuff() {
        System.out.println("TennisCoach >> Inside the doMyStartupStuff");
    }

    // define a cleanup method
    @PreDestroy
    private void doMyCleanupStuff() {
        System.out.println("TennisCoach >> Inside the doMyCleanupStuff");
    }

    @Autowired
    public void setFortuneService(@Qualifier("fileFortuneService") FortuneService fortuneService) {
        System.out.println("Inside tennis coach setter method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        System.out.println("email: " + email);
        System.out.println("team: " + team);
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
