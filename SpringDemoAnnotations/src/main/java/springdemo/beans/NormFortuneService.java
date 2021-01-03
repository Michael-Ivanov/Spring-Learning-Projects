package springdemo.beans;

import org.springframework.stereotype.Component;

@Component
public class NormFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is just regular day. Like all other days :/";
    }
}
