package miv.study.springdemo.beans;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // add an init method
    private void doMyStartupStuff() {
        System.out.println("TrackCoach: inside Init method.");
    }
    // add a destroy method
    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside Cleanup method.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("TrackCoach: inside destroy method.");
    }
}
