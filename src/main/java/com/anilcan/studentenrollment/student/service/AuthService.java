package com.anilcan.studentenrollment.student.service;

import com.anilcan.studentenrollment.utils.exception.InvalidPhoneNumberException;
import com.anilcan.studentenrollment.utils.exception.StudentAlreadyRegisteredException;
import com.anilcan.studentenrollment.utils.exception.StudentNotFoundException;
import com.anilcan.studentenrollment.student.model.entity.Student;
import com.anilcan.studentenrollment.student.model.request.LoginRequest;
import com.anilcan.studentenrollment.student.model.request.RegisterRequest;
import com.anilcan.studentenrollment.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final StudentRepository studentRepository;

    public ImmutableTriple<String, String, String> register(RegisterRequest req) {
        log.info("register service processing.");
        System.out.println(req);

        var maybeStudent = studentRepository.findStudentByEmail(req.email());

        if (maybeStudent.isPresent())
            throw new StudentAlreadyRegisteredException();

        if (!isPhoneNumberValid(req.phoneNumber()))
            throw new InvalidPhoneNumberException();

        var phoneNumber = req.phoneNumber().replaceAll("\\s", "")
                .replaceAll("[()]", "")
                .substring(1);

        var hashedPw = BCrypt.hashpw(req.password(), BCrypt.gensalt());

        var savedStudent = studentRepository.save(Student.builder()
                .firstName(req.firstName())
                .lastName(req.lastName())
                .email(req.email())
                .password(hashedPw)
                .dateOfBirth(req.dateOfBirth())
                .phoneNumber(phoneNumber)
                .build());

        return new ImmutableTriple<>(savedStudent.getFirstName(), savedStudent.getLastName(), savedStudent.getEmail());
    }

    public ImmutablePair<Boolean, Boolean> login(LoginRequest req) {
        log.info("login service processing.");
        var maybeStudent = studentRepository.findStudentByEmail(req.email());

        if (maybeStudent.isEmpty())
            throw new StudentNotFoundException();

        var isAuthorized = BCrypt.checkpw(req.password(), maybeStudent.get().getPassword());
        var isProfileSet = maybeStudent.get().getProfile() != null;

        return new ImmutablePair<>(isAuthorized, isProfileSet);
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // turkey phone number regex
        String regex = "0\\([0-9]+\\)\\s[0-9]+\\s[0-9]+\\s[0-9]++";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}