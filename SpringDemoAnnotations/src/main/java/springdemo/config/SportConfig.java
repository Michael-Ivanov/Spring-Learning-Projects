package springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springdemo.beans.Coach;
import springdemo.beans.FortuneService;
import springdemo.beans.SadFortuneService;
import springdemo.beans.SwimCoach;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan(basePackages = {"springdemo"})
public class SportConfig {

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach() {
        System.out.println("Creating swimCoach!");
        return new SwimCoach(sadFortuneService());
    }

}
