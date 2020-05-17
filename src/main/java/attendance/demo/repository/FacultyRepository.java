package attendance.demo.repository;

import attendance.demo.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional()
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Query("select f from Faculty f where f.username=:name")
    Faculty findByUserName(String name);
}
