package attendance.demo.service.student;

import attendance.demo.domain.Student;
import attendance.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Student addStudent(Student student) {
		String hashedPassword = passwordEncoder.encode(student.getPassword());
		Student student1 = student;
		student1.setPassword(hashedPassword);
		return studentRepository.save(student1);
	}

	@Override
	public List<Student> getStudentListBySession(int sessionId) {
		return studentRepository.getStudentListBySession(sessionId);
	}

	@Override
	public List<Student> getStudentListByCourseOffering(int courseOfferingId) {
		return studentRepository.getStudentListByCourseOffering(courseOfferingId);
	}

	@Override
	public List<Student> getStudentListByCourse(String courseId) {
		return studentRepository.getStudentListByCourse(courseId);
	}
}
