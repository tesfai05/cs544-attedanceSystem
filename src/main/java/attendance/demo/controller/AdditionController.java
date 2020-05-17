package attendance.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import attendance.demo.service.course.CourseService;
@Controller
public class AdditionController {
	
	@Autowired
	private CourseService courseService;
	 
	@GetMapping("/add")
	public String  add() {
//		model.addAttribute("courseId",course.getCourseId());
//		model.addAttribute("courseName", course.getName());
//		model.addAttribute("courseDescription", course.getDescription());
		courseService.findAll();
		return "/course";
		
	}

}
