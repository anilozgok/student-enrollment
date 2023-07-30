package com.anilcan.studentenrollment.utils.database;

import com.anilcan.studentenrollment.course.model.entity.Course;
import com.anilcan.studentenrollment.course.repository.CourseRepository;
import com.anilcan.studentenrollment.enrollment.model.entity.Enrollment;
import com.anilcan.studentenrollment.enrollment.repository.EnrollmentRepository;
import com.anilcan.studentenrollment.student.model.entity.Student;
import com.anilcan.studentenrollment.student.model.entity.StudentProfile;
import com.anilcan.studentenrollment.student.repository.StudentProfileRepository;
import com.anilcan.studentenrollment.student.repository.StudentRepository;
import com.anilcan.studentenrollment.utils.Gender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatabaseService {
    private final StudentRepository studentRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public void initialize() {


        log.info("initializing database");

        var students = List.of(
                Student.builder()
                        .firstName("Anıl Can")
                        .lastName("Ozgok")
                        .email("anilcan@gmail.com")
                        .password(BCrypt.hashpw("anilcan123", BCrypt.gensalt()))
                        .dateOfBirth(LocalDate.of(2001, 05, 25))
                        .phoneNumber("5323425634")
                        .build(),

                Student.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("john.doe@gmail.com")
                        .password(BCrypt.hashpw("johnDoe123", BCrypt.gensalt()))
                        .dateOfBirth(LocalDate.of(2001, 06, 26))
                        .phoneNumber("5323425635")
                        .build(),

                Student.builder()
                        .firstName("Jenny")
                        .lastName("Doe")
                        .email("jenny.doe@gmail.com")
                        .password(BCrypt.hashpw("jennyDoe123", BCrypt.gensalt()))
                        .dateOfBirth(LocalDate.of(2001, 07, 27))
                        .phoneNumber("5323425636")
                        .build()
        );

        studentRepository.saveAll(students);


        var studentProfiles = List.of(
                StudentProfile.builder()
                        .gender(Gender.MALE)
                        .nationality("Turkish")
                        .major("Software Engineering")
                        .yearOfAdmission(2020)
                        .build(),

                StudentProfile.builder()
                        .gender(Gender.MALE)
                        .nationality("English")
                        .major("Computer Engineering")
                        .yearOfAdmission(2019)
                        .build(),

                StudentProfile.builder()
                        .gender(Gender.FEMALE)
                        .nationality("German")
                        .major("Computer Engineering")
                        .yearOfAdmission(2019)
                        .build()

        );

        studentProfileRepository.saveAll(studentProfiles);

        var courses = List.of(
                Course.builder()
                        .name("Introduction to Software Engineering")
                        .code("SWE1")
                        .credit(4)
                        .build(),

                Course.builder()
                        .name("Computer Programming 1")
                        .code("CPP1")
                        .credit(4)
                        .build(),

                Course.builder()
                        .name("Calculus 1")
                        .code("CALC1")
                        .credit(3)
                        .build()
        );

        courseRepository.saveAll(courses);

        var enrollments = List.of(
                Enrollment.builder()
                        .student(students.get(0))
                        .course(courses.get(0))
                        .enrollmentDate(LocalDate.now())
                        .build(),
                Enrollment.builder()
                        .student(students.get(0))
                        .course(courses.get(2))
                        .enrollmentDate(LocalDate.now())
                        .build(),

                Enrollment.builder()
                        .student(students.get(1))
                        .course(courses.get(1))
                        .enrollmentDate(LocalDate.now())
                        .build(),
                Enrollment.builder()
                        .student(students.get(1))
                        .course(courses.get(2))
                        .enrollmentDate(LocalDate.now())
                        .build(),

                Enrollment.builder()
                        .student(students.get(2))
                        .course(courses.get(2))
                        .enrollmentDate(LocalDate.now())
                        .build()
        );

        enrollmentRepository.saveAll(enrollments);


    }


}
