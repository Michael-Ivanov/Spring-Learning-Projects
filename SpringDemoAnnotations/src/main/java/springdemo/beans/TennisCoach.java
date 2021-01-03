package springdemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@SuppressWarnings("CommentedOutCode")
@Component
public class TennisCoach implements Coach {
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(@Qualifier("normFortuneService") FortuneService fortuneService) {
//        System.out.println("Inside tennis coach constructor");
//        this.fortuneService = fortuneService;
//    }

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
