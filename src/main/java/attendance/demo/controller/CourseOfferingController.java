package attendance.demo.controller;
import attendance.demo.domain.CourseOffering;
import attendance.demo.service.courseOffering.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import attendance.demo.service.courseOffering.CourseOfferingService;

import java.util.List;

@RestController
public class CourseOfferingController {
	@Autowired
	private CourseOfferingService courseOfferingService;


	@PreAuthorize("hasAnyAuthority('ADMIN','ROLE_FACULTY')")
	@GetMapping(value="/courseOfferings",produces = MediaType.APPLICATION_JSON_VALUE)

	public List<CourseOffering> getAllCourseOfferings() {
		return courseOfferingService.getAllCourseOfferings();

	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value="/courseOfferings")
	public CourseOffering addCourseOffering(@RequestBody CourseOffering courseOffering, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Error! Checkout your entries please ! ");
		}
		return courseOfferingService.addCourseOffering(courseOffering);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','ROLE_FACULTY')")
	@GetMapping(value="/courseOfferings/{id}")
	public CourseOffering getCourseOffering(@PathVariable Integer id) {
		return courseOfferingService.getCourseOfferingById(id);

	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping(value="/courseOfferings")
	public CourseOffering updateCourseOffering(@RequestBody CourseOffering courseOffering, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Error! Checkout your entries please ! ");
		}

		return courseOfferingService.updateCourseOffering(courseOffering);

	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping(value="/courseOfferings/{id}")
	public boolean deleteCourseOffering(@PathVariable Integer id) {

		return courseOfferingService.deleteCourseOfferingById(id);
	}

	@PreAuthorize("hasAuthority('ROLE_FACULTY')")
	@GetMapping(value = "/faculty/attendancepercent/courseoffering/{courseofferingid}")
	public double calculateCourseOfferingPecent(@PathVariable("courseofferingid") int courseOfferingId) {
		return courseOfferingService.countAttendancePercentInCourseOffering(courseOfferingId);
	}
}
