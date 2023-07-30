package com.anilcan.studentenrollment.student.repository;

import com.anilcan.studentenrollment.student.model.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    List<StudentProfile> findStudentProfilesByNationality(String nationality);
}
