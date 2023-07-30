package com.anilcan.studentenrollment.enrollment.model.entity;

import com.anilcan.studentenrollment.course.model.entity.Course;
import com.anilcan.studentenrollment.student.model.entity.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="course", nullable=false)
    private Course course;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

}
