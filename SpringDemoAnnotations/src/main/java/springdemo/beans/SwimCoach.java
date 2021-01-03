package springdemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    public SwimCoach() {
    }

//    @Autowired
//    public SwimCoach(FortuneService fortuneService) {
//        System.out.println("Inside the parameter constructor method");
//        System.out.println("Incoming FortuneService is: " + fortuneService.getFortune());
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Swim 5 km right now";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("Inside the setter method");
//        this.fortuneService = fortuneService;
//    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println("Inside the crazy method");
//        this.fortuneService = fortuneService;
//    }
}
