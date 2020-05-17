package attendance.demo.repository;

import attendance.demo.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional()
public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {

    @Query("select admin from Administrator admin where admin.username=:name")
    Administrator findAdministratorByUsername(String name);
}
