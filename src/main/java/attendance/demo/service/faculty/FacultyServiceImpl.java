package attendance.demo.service.faculty;

import attendance.demo.domain.Faculty;
import attendance.demo.domain.Student;
import attendance.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional findById(int id) {
        return facultyRepository.findById(id);
    }

    @Override
    public Faculty save(Faculty faculty) {

        String hashedPassword = passwordEncoder.encode(faculty.getPassword());
        Faculty faculty1= faculty;
        faculty1.setPassword(hashedPassword);
        return facultyRepository.save(faculty);
    }

    @Override
    public void delete(int id) {
        facultyRepository.deleteById(id);
    }
}
