package attendance.demo.repository;

import attendance.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attendance.demo.domain.Course;

import javax.transaction.Transactional;

@Repository
@Transactional()
public interface CourseRepository extends JpaRepository<Course, Integer> {
}