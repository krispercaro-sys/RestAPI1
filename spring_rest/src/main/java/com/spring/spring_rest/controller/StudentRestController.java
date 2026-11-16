package com.spring.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

/**
 * REST controller for managing student resources.
 */
@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    /**
     * Initializes the in-memory list of students after bean
     * construction.
     */
    @PostConstruct
    public void initialize() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Light", "Yagami"));
        theStudents.add(new Student("Leslie", "Andrews"));
        theStudents.add(new Student("Emma", "Baumgarten"));
    }

    /**
     * Retrieves a student by their index ID.
     *
     * @param studentId the index ID of the student to retrieve
     * @return the matching {@link Student} object
     * @throws StudentNotFoundException if {@code studentId} is out of
     *                                  bounds
     */
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || (studentId < 0)) {
            throw new StudentNotFoundException(
                    "Student id" + studentId + "not found!");
        }
        return theStudents.get(studentId);
    }

}