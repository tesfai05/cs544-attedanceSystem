package attendance.demo.service.administrator;

import attendance.demo.domain.Administrator;
import attendance.demo.domain.Faculty;

import java.util.List;
import java.util.Optional;

public interface AdministratorService {
    List<Administrator> findAll();
    Optional findById(int id);
    Administrator save(Administrator administrator);
    void delete(int id);
    void delete2();
}
