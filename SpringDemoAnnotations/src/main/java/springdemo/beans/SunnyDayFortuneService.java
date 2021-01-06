package springdemo.beans;

public class SunnyDayFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Some really sunny day is waiting for you";
    }
}
