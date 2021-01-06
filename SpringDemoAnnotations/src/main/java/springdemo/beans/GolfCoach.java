package springdemo.beans;

public class GolfCoach implements Coach {

    private FortuneService fortuneService;


    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("In setter method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your pit escape hit for one hour";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
