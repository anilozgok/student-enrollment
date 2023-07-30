package com.anilcan.studentenrollment.student.service;

import com.anilcan.studentenrollment.student.model.domain.StudentDomain;
import com.anilcan.studentenrollment.student.model.domain.StudentProfileDomain;
import com.anilcan.studentenrollment.student.model.entity.StudentProfile;
import com.anilcan.studentenrollment.student.model.request.StudentProfileRequest;
import com.anilcan.studentenrollment.student.repository.StudentProfileRepository;
import com.anilcan.studentenrollment.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentProfileRepository profileRepository;

    public StudentProfileDomain createStudentProfile(StudentProfileRequest req) {
        log.info("createStudentProfile service processing.");
        var savedProfile = profileRepository.save(StudentProfile.builder()
                .gender(req.gender())
                .nationality(req.nationality())
                .major(req.major())
                .yearOfAdmission(req.yearOfAdmission())
                .build());


        return new StudentProfileDomain(savedProfile.getGender(), savedProfile.getNationality(), savedProfile.getMajor(), savedProfile.getYearOfAdmission());
    }

    public List<ImmutableTriple<Long, StudentDomain, StudentProfileDomain>> getStudents() {
        log.info("getStudents service processing.");
        return studentRepository.findAll().stream().map(student ->
                new ImmutableTriple<>(
                        student.getId(),
                        new StudentDomain(
                                student.getFirstName(),
                                student.getLastName(),
                                student.getEmail(),
                                student.getDateOfBirth(),
                                student.getPhoneNumber()),
                        new StudentProfileDomain(
                                student.getProfile().getGender(),
                                student.getProfile().getNationality(),
                                student.getProfile().getMajor(),
                                student.getProfile().getYearOfAdmission())
                )
        ).collect(Collectors.toList());
    }

}