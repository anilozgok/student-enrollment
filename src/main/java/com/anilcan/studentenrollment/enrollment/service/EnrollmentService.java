package com.anilcan.studentenrollment.enrollment.service;

import com.anilcan.studentenrollment.course.model.domain.CourseDomain;
import com.anilcan.studentenrollment.course.repository.CourseRepository;
import com.anilcan.studentenrollment.enrollment.model.entity.Enrollment;
import com.anilcan.studentenrollment.enrollment.model.request.EnrollRequest;
import com.anilcan.studentenrollment.enrollment.model.response.EnrollmentResponse;
import com.anilcan.studentenrollment.enrollment.repository.EnrollmentRepository;
import com.anilcan.studentenrollment.student.model.domain.StudentDomain;
import com.anilcan.studentenrollment.student.repository.StudentRepository;
import com.anilcan.studentenrollment.utils.exception.CourseNotFoundException;
import com.anilcan.studentenrollment.utils.exception.StudentNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    public void enroll(EnrollRequest req) {
        log.info("enroll service processing.");
        var student = studentRepository.findById(req.studentId()).orElseThrow(StudentNotFoundException::new);
        var course = courseRepository.findById(req.courseId()).orElseThrow(CourseNotFoundException::new);


        var savedEnrollment = enrollmentRepository.save(Enrollment.builder()
                .student(student)
                .course(course)
                .enrollmentDate(LocalDate.now())
                .build());

        //return new ImmutableTriple<>(savedEnrollment.getId(), savedEnrollment.getStudent(), savedEnrollment.getCourse());
    }

    @Transactional
    public void delete(Long id) {
        log.info("delete service processing.");
        enrollmentRepository.deleteById(id);
    }

    public List<EnrollmentResponse> getEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(enrollment ->
                        new EnrollmentResponse(
                                enrollment.getId(),
                                new StudentDomain(
                                        enrollment.getStudent().getFirstName(),
                                        enrollment.getStudent().getLastName(),
                                        enrollment.getStudent().getEmail(),
                                        enrollment.getStudent().getDateOfBirth(),
                                        enrollment.getStudent().getPhoneNumber()
                                ),
                                new CourseDomain(
                                        enrollment.getCourse().getName(),
                                        enrollment.getCourse().getCode(),
                                        enrollment.getCourse().getCredit()
                                )

                        )
                ).collect(Collectors.toList());
    }


}
