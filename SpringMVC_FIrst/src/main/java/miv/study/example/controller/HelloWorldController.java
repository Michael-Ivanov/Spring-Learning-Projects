package miv.study.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // need a controller method to show the init HTML form

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String processFormVersionTwo(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the name to uppercase and create the message
        theName = theName.toUpperCase(Locale.ROOT);
        String result = "YO, " + theName;

        // add message to the model
        model.addAttribute("yoMessage", result);
        model.addAttribute("someObject", new Object());

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam(defaultValue = "noname", value = "studentName") String theName,
            Model model) {

        // convert the name to uppercase and create the message

        String result = "Hello, my friend " + theName;

        // add message to the model
        model.addAttribute("yoMessage", result);
        model.addAttribute("someObject", new Object());


        return "helloworld";
    }


}
