package miv.study.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean flag) {
        if (flag) {
            throw new RuntimeException("Catch it now. Major accident!");
        }
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // return a fortune
        return "Expect heavy traffic this morning";
    }
}
