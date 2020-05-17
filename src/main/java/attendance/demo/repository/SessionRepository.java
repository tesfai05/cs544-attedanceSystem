package attendance.demo.repository;

import attendance.demo.domain.CourseOffering;
import attendance.demo.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SessionRepository extends JpaRepository<Session, Integer> {

	List<Session> findByCourseOffering(CourseOffering courseOffering);

	@Query("select count(*) from Session s where s.courseOffering.courseOfferingId=:courseOfferingId")
	int countByCourseOffering(@Param("courseOfferingId") int courseOfferingId);
}