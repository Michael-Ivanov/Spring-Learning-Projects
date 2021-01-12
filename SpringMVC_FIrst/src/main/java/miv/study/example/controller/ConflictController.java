package miv.study.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConflictController {

    @RequestMapping("/showForm")
    public String displayTheForm() {
        return "conflict";
    }
}
