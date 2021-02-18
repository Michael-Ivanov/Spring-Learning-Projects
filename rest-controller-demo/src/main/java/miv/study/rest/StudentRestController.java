package miv.study.rest;

import miv.study.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    @PostConstruct
    public void loadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("John", "Malkovich"));
        studentList.add(new Student("John", "Watson"));
        studentList.add(new Student("John", "McClane"));
        studentList.add(new Student("John", "Bon Jovi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return studentList.get(studentId);
    }
}
