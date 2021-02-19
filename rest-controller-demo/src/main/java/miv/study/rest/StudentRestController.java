package miv.study.rest;

import miv.study.entity.Student;
import miv.study.entity.StudentErrorResponse;
import miv.study.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        try {
            return studentList.get(studentId);
        } catch (IndexOutOfBoundsException e) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllExceptions(Exception exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
