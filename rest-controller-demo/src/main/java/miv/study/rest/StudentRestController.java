package miv.study.rest;

import miv.study.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", "Malkovich"));
        studentList.add(new Student("John", "Watson"));
        studentList.add(new Student("John", "McClane"));
        studentList.add(new Student("John", "Bon Jovi"));

        return studentList;
    }
}
