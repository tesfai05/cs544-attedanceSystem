package attendance.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import attendance.demo.domain.AttendanceRecord;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AttendanceRepository extends JpaRepository<AttendanceRecord, Integer> {

	@Query("select a from Session s, AttendanceRecord a "
			+ "where s.timeslot.id = a.timeslot.id "
			+ "and s.date = a.date "
			+ "and s.id=:sessionId")
	List<AttendanceRecord> getSessionRecords(@Param("sessionId") int sessionId);

	@Query("select a from AttendanceRecord a, Session s, CourseOffering c "
			+ "where s.date = a.date "
			+ "and s.timeslot.id = a.timeslot.id "
			+ "and c.courseOfferingId = s.courseOffering.courseOfferingId "
			+ "and c.location.id = a.location.id "
			+ "and a.student.studentId=:studentId "
			+ "and s.courseOffering.courseOfferingId=:courseOfferingId "
			+ "order by a.date, s.timeslot.id")
	List<AttendanceRecord> getStudentRecordsInCourseOffering(@Param("studentId") String studentId, @Param("courseOfferingId") int courseOfferingId);

	@Query("select count(*) from AttendanceRecord a, Session s, CourseOffering c "
			+ "where s.date = a.date "
			+ "and s.timeslot.id = a.timeslot.id "
			+ "and c.courseOfferingId = s.courseOffering.courseOfferingId "
			+ "and c.location.id = a.location.id "
			+ "and s.courseOffering.courseOfferingId=:courseOfferingId "
			+ "and s.date between c.startDate and c.endDate")
	int countRecordsInCourseOffering(@Param("courseOfferingId") int courseOfferingId);

	@Query("select a from AttendanceRecord a where a.student.studentId=:studentId")
	List<AttendanceRecord> getStudentAttendance(@Param("studentId") String studentId);
}