package com.anilcan.studentenrollment.enrollment.repository;

import com.anilcan.studentenrollment.enrollment.model.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
