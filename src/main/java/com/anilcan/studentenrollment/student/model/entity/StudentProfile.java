package com.anilcan.studentenrollment.student.model.entity;

import com.anilcan.studentenrollment.utils.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "StudentProfile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private Gender gender;

    @Column(nullable = false, length = 50)
    private String nationality;

    @Column(nullable = false, length = 50)
    private String major;

    @Column(nullable = false)
    private int yearOfAdmission;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "profile")
    private Student student;

}
