package miv.study.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String getSomething() {

        return "Hello World! Time on server is " + LocalDateTime.now();
    }

    // expose a new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
