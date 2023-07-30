package com.anilcan.studentenrollment.student.rest;

import com.anilcan.studentenrollment.student.model.request.LoginRequest;
import com.anilcan.studentenrollment.student.model.request.RegisterRequest;
import com.anilcan.studentenrollment.student.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/")
    public String home() {
        return "homepage";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest registerRequest) {
        log.info("Register request caught by controller");

        var registeredStudent = authService.register(registerRequest);

        return "login";
        /*return new ResponseEntity<>(
                new AuthResponse(registeredStudent.left, registeredStudent.middle, registeredStudent.right),
                HttpStatus.CREATED);*/
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest) {
        log.info("Login request caught by auth controller.");
        var loginInfo = authService.login(loginRequest);
        var isAuthorized = loginInfo.left;
        var isProfileSet = loginInfo.right;

        if (isAuthorized && isProfileSet)
            return "redirect:/api/course/list";
        else if (isAuthorized || !isProfileSet)
            return "profile";

        return "login";
    }


}