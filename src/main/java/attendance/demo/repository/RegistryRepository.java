package attendance.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import attendance.demo.domain.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {
	@Query("select count(*) from Registry r where r.courseOffering.courseOfferingId=:courseOfferingId")
	int countByCourseOffering(@Param("courseOfferingId") int courseOfferingId);
}
