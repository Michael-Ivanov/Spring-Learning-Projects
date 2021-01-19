package miv.study.example.controller;

import miv.study.example.bean.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/student")
public class StudentController {


    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        // create a new student object
        Student theStudent = new Student();
        theStudent.setFirstName("Mike");

        // add student object to the model
        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent, HttpServletRequest request) {

        // log the input data
        System.out.println("theStudent from model: "
                + theStudent.getFirstName() + " "
                + theStudent.getLastName());

        System.out.println("theStudent from request: "
                + request.getParameter("firstName") + " "
                + request.getParameter("lastName"));
        return "student-confirmation";
    }
}
