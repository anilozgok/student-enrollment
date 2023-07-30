package com.anilcan.studentenrollment.course.model.entity;

import com.anilcan.studentenrollment.enrollment.model.entity.Enrollment;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 6)
    private String code;

    @Column(nullable = false)
    private int credit;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;

}
