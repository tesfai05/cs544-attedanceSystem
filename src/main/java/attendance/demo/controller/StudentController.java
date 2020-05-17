package attendance.demo.controller;

import java.util.List;
import attendance.demo.domain.Student;
import attendance.demo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PreAuthorize("hasAuthority('ROLE_FACULTY')")
	@GetMapping(value = "/faculty/students/session/{sessionid}")
	public List<Student> getStudentListBySession(@PathVariable("sessionid") int sessionId) {
		return studentService.getStudentListBySession(sessionId);
	}
	@PreAuthorize("hasAuthority('ROLE_FACULTY')")
	@GetMapping(value = "/faculty/students/courseoffering/{courseofferingid}")
	public List<Student> getStudentListByCourseOffering(@PathVariable("courseofferingid") int courseOfferingId) {
		return studentService.getStudentListByCourseOffering(courseOfferingId);
	}
	@PreAuthorize("hasAuthority('ROLE_FACULTY')")
	@GetMapping(value = "/faculty/students/course/{courseid}")
	public List<Student> getStudentListByCourse(@PathVariable("courseid") String courseId) {
		return studentService.getStudentListByCourse(courseId);
	}

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "admin/students",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


}
