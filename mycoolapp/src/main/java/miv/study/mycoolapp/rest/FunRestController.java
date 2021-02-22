package miv.study.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String getSomething() {
        return "Hello World! Time on server is " + LocalTime.now();
    }
}
