package miv.study.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new Date());
        return "home";
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "custom-login";
    }
}
