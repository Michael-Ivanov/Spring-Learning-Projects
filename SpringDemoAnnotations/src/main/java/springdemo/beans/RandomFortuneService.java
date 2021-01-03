package springdemo.beans;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] fortunes = {
            "Beware of the wolf in sheep clothes",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(fortunes.length);
        return fortunes[index];
    }
}
