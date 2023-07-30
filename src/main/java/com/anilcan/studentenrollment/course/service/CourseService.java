package com.anilcan.studentenrollment.course.service;

import com.anilcan.studentenrollment.utils.exception.CourseAlreadyExistException;
import com.anilcan.studentenrollment.utils.exception.CourseNotFoundException;
import com.anilcan.studentenrollment.course.model.domain.CourseDomain;
import com.anilcan.studentenrollment.course.model.entity.Course;
import com.anilcan.studentenrollment.course.model.request.NewCourseRequest;
import com.anilcan.studentenrollment.course.model.request.UpdateCourseRequest;
import com.anilcan.studentenrollment.course.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseDomain saveCourse(NewCourseRequest req) {

        log.info("");

        var maybeCourse = courseRepository.getCourseByCode(req.code());

        if (maybeCourse.isPresent())
            throw new CourseAlreadyExistException();

        var savedCourse = courseRepository.save(Course.builder()
                .name(req.name())
                .code(req.code())
                .credit(req.credit())
                .build());

        return new CourseDomain(savedCourse.getName(), savedCourse.getCode(), savedCourse.getCredit());
    }

    public List<ImmutablePair<Long, CourseDomain>> getCourses() {
        return courseRepository.findAll().stream()
                .map(course ->
                        new ImmutablePair<>(course.getId(), new CourseDomain(course.getName(), course.getCode(), course.getCredit())))
                .collect(Collectors.toList());
    }

    public ImmutablePair<Long, CourseDomain> getCourseByCode(String courseCode) {
        var course = courseRepository.getCourseByCode(courseCode).orElseThrow(CourseNotFoundException::new);

        return new ImmutablePair<>(course.getId(), new CourseDomain(course.getName(), course.getCode(), course.getCredit()));
    }

    @Transactional
    public void updateCourse(UpdateCourseRequest req) {
        var courseToUpdate = courseRepository.findById(req.id()).orElseThrow(CourseNotFoundException::new);

        courseToUpdate.setName(req.name());
        courseToUpdate.setCode(req.code());
        courseToUpdate.setCredit(req.credit());

        courseRepository.save(courseToUpdate);

    }

    @Transactional
    public void deleteCourse(Long id) {
        log.info("delete course processing");
        courseRepository.deleteById(id);
    }
}
