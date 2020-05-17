package attendance.demo.repository;

import attendance.demo.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional()
public interface LocationRepository extends JpaRepository<Location, Integer> {
}