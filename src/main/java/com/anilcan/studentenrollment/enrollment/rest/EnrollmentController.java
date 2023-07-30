package com.anilcan.studentenrollment.enrollment.rest;


import com.anilcan.studentenrollment.enrollment.model.request.EnrollRequest;
import com.anilcan.studentenrollment.enrollment.service.EnrollmentService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping("/enroll")
    public String enroll(){
        return "enroll";
    }

    @PostMapping("/enroll")
    public String enroll(@ModelAttribute @NotNull EnrollRequest enrollRequest){
        log.info("enroll request caught by controller.");
        enrollmentService.enroll(enrollRequest);
        return "redirect:/api/enrollment/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        log.info("delete request caught by controller.");
        enrollmentService.delete(id);
        return "redirect:/api/enrollment/list";
    }

    @GetMapping("/list")
    public String getEnrollments(Model model){
        log.info("get enrollments request caught by controller.");
        model.addAttribute("enrollments", enrollmentService.getEnrollments());
        return "enrollments";
    }
}
