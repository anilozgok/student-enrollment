package com.anilcan.studentenrollment.course.rest;

import com.anilcan.studentenrollment.course.model.request.NewCourseRequest;
import com.anilcan.studentenrollment.course.model.request.UpdateCourseRequest;
import com.anilcan.studentenrollment.course.model.response.CourseResponse;
import com.anilcan.studentenrollment.course.service.CourseService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/save")
    public String saveCourse() {
        return "course";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute NewCourseRequest newCourseRequest) {
        log.info("new course request caught by the controller.");
        var savedCourse = courseService.saveCourse(newCourseRequest);
        return "redirect:/api/course/list";
        //return new ResponseEntity<>(new CourseResponse(savedCourse), HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public String getCourses(Model model) {
        log.info("get courses request caught by controller.");
        var courses = courseService.getCourses().stream()
                .map(course -> new CourseResponse(course.left, course.right.name(), course.right.code(), course.right.credit()))
                .collect(Collectors.toList());
        model.addAttribute("courses", courses);
        //return new ResponseEntity<>(new CourseListResponse(courses), HttpStatus.OK);
        return "courses";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") @NotNull Long id) {
        log.info("delete course request caught by controller.");
        courseService.deleteCourse(id);
        return "redirect:/api/course/list";
    }

    @GetMapping("/update")
    public String update() {
        return "update-course";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @NotNull UpdateCourseRequest updateCourseRequest) {
        log.info("update course request caught by controller");
        courseService.updateCourse(updateCourseRequest);
        return "redirect:/api/course/list";
    }

    @GetMapping("/by-code")
    public String getByCode(@RequestParam(value="code") String code, Model model) {
        log.info("get course by code service caught by controller.");
        var course = courseService.getCourseByCode(code);
        model.addAttribute("courses",
                new CourseResponse(course.left, course.right.name(), course.right.code(), course.right.credit()));
        return "courses";
    }

}
