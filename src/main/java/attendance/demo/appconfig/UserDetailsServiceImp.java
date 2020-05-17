package attendance.demo.appconfig;

import attendance.demo.domain.AbstractUser;
import attendance.demo.domain.Administrator;
import attendance.demo.domain.Faculty;
import attendance.demo.domain.Student;
import attendance.demo.repository.AdministratorRepository;
import attendance.demo.repository.FacultyRepository;
import attendance.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    private AbstractUser abstractUser;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student = studentRepository.findByUserName(s);
        Faculty faculty = facultyRepository.findByUserName(s);
        Administrator administrator = administratorRepository.findAdministratorByUsername(s);

        if (student!=null){
            abstractUser = student;
        }
        else if(faculty!=null){
            abstractUser = faculty;
        }
        else {
            abstractUser = administrator;
        }

        if (abstractUser==null)
            throw new UsernameNotFoundException("user name not found");
        return new UserDetailsImp(abstractUser);
    }
}
