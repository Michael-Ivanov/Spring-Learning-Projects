package miv.study.springdemo.beans;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private String[] fortunes;

    public RandomFortuneService() {
        fortunes = new String[]{
                "Today is your lucky day!",
                "May the force be with you!",
                "Be persistent and adequate!"};
    }

    @Override
    public String getFortune() {
        int randomFortuneIndex = new Random().nextInt(fortunes.length);
        return fortunes[randomFortuneIndex];
    }
}
