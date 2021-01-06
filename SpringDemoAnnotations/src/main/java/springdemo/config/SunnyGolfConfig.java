package springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springdemo.beans.*;

@Configuration
public class SunnyGolfConfig {

    @Bean
    public FortuneService sunnyFortuneService() {
        return new SunnyDayFortuneService();
    }

    @Bean
    public FortuneService normFortuneService() {
        return new NormFortuneService();
    }

    @Bean
    public Coach golfCoach() {
        GolfCoach coach = new GolfCoach();
        coach.setFortuneService(sunnyFortuneService());
        return coach;
    }
}
