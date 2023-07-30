package com.anilcan.studentenrollment.student.rest;


import com.anilcan.studentenrollment.student.model.request.StudentProfileRequest;
import com.anilcan.studentenrollment.student.model.response.StudentResponse;
import com.anilcan.studentenrollment.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/profile")
    public String createStudentProfile() {
        return "profile";
    }

    @PostMapping("/profile")
    public String  createStudentProfile(@ModelAttribute StudentProfileRequest studentProfileRequest) {
        log.info("create student profile request caught.");
        var studentProfile = studentService.createStudentProfile(studentProfileRequest);
        return "redirect:/api/course/list";
        //return new ResponseEntity<>(new StudentProfileResponse(studentProfile), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public String getStudents(Model model) {
        log.info("get students request caught.");
        var students = studentService.getStudents().stream()
                .map(pair -> new StudentResponse(pair.left, pair.middle, pair.right)).toList();
        model.addAttribute("students", students);
        return "students";
        //return new ResponseEntity<>(new StudentListResponse(studentList), HttpStatus.OK);

    }
}
