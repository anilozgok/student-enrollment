package com.anilcan.studentenrollment.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("")
    public ResponseEntity<String> getStudents() {
        return new ResponseEntity<>("student list", HttpStatus.OK);
    }
}
