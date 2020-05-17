package attendance.demo.repository;
import attendance.demo.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional()
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {
}