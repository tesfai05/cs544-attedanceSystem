package attendance.demo.controller;

import attendance.demo.domain.Course;
import attendance.demo.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PreAuthorize("hasAnyAuthority('ADMIN','ROLE_FACULTY')")
    @GetMapping("/admin/courses")
    public String getAllCourses(Model model) {
       model.addAttribute("courses", courseService.findAll());
       
       return "/courses";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/courses/{id}")
    public Optional getCourse(@PathVariable Integer id){
        return courseService.findById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/admin/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.save(course);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value ="/admin/courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
         courseService.delete(id);
    }



}
