package com.learnspring.demo.rest;

import com.learnspring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentsList;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData() {
        studentsList = new ArrayList<>();
        studentsList.add(new Student("Poornima", "Patel"));
        studentsList.add(new Student("Mario", "Rossi"));
        studentsList.add(new Student("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentsList;
    }

    // define an endpoint for "/student/{studentId}"
    // this will return the student at given index
    // the name "studentId" in getMapping and PathVariable should match
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= studentsList.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return studentsList.get(studentId);
    }

}
