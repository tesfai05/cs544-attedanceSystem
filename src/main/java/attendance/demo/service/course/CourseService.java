package attendance.demo.service.course;

import java.util.List;
import java.util.Optional;

import attendance.demo.domain.Course;

public interface CourseService {

	List<Course> findAll();
	Optional findById(int id);
	Course save(Course course);
	void delete(int id);

}