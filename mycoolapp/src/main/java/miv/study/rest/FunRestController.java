package miv.study.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;
    @Value("${coach.team}")
    private String coachTeam;

    @GetMapping("/")
    public String getSomething() {

        return "Hello World! Time on server is " + LocalDateTime.now() +
                "<br> Coach Name is " + coachName +
                "<br> Coach Team is " + coachTeam;
    }

    // expose a new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
