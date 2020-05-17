package attendance.demo.service.faculty;

import attendance.demo.domain.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {

    List<Faculty> findAll();
    Optional findById(int id);
    Faculty save(Faculty faculty);
    void delete(int id);
}
