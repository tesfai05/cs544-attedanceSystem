package attendance.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import attendance.demo.domain.Student;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.username=:name")
    Student findByUserName(String name);

	@Query("select distinct ss from Student ss,  Session s, AttendanceRecord a, CourseOffering c  "
			+ "where s.timeslot.id = a.timeslot.id "
			+ "and s.date = a.date "
			+ "and ss.id = a.student.id "
			+ "and c.courseOfferingId = s.courseOffering.courseOfferingId "
			+ "and c.location.id = a.location.id "
			+ "and s.id=:sessionId")
	List<Student> getStudentListBySession(@Param("sessionId") int sessionId);

	@Query("select distinct ss from Student ss,  Session s, AttendanceRecord a, CourseOffering c "
			+ "where s.timeslot.id = a.timeslot.id "
			+ "and s.date = a.date "
			+ "and ss.id = a.student.id "
			+ "and c.courseOfferingId = s.courseOffering.courseOfferingId "
			+ "and c.location.id = a.location.id "
			+ "and s.courseOffering.courseOfferingId=:courseOfferingId")
	List<Student> getStudentListByCourseOffering(@Param("courseOfferingId") int courseOfferingId);

	@Query("select distinct ss from Student ss,  Session s, AttendanceRecord a, CourseOffering c, Course cs "
			+ "where s.timeslot.id = a.timeslot.id "
			+ "and s.date = a.date "
			+ "and ss.id = a.student.id "
			+ "and c.courseOfferingId = s.courseOffering.courseOfferingId "
			+ "and c.location.id = a.location.id "
			+ "and c.course.id = cs.id "
			+ "and cs.courseId=:courseId")
	List<Student> getStudentListByCourse(@Param("courseId") String courseId);
}