package attendance.demo.service.courseOffering;
import attendance.demo.domain.CourseOffering;
import attendance.demo.repository.AttendanceRepository;
import attendance.demo.repository.CourseOfferingRepository;
import attendance.demo.repository.RegistryRepository;
import attendance.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseOfferingServiceImpl implements CourseOfferingService {

	@Autowired
	private CourseOfferingRepository courseOfferingRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private RegistryRepository registryRepository;

	@Autowired
	private AttendanceRepository attendanceRepository;

		public CourseOffering addCourseOffering(CourseOffering courseOffering) {
			courseOfferingRepository.save(courseOffering);
			return courseOffering;
		}


		public CourseOffering updateCourseOffering(CourseOffering courseOffering) {
			courseOfferingRepository.save(courseOffering);
			return courseOffering;
		}
	public boolean deleteCourseOfferingById(int id) {
		courseOfferingRepository.deleteById(id);
		return true;
	}

	public CourseOffering getCourseOfferingById(int id) {
		Optional<CourseOffering> opt= courseOfferingRepository.findById(id);
		return opt.get();
	}

	public List<CourseOffering> getAllCourseOfferings() {
		return courseOfferingRepository.findAll();
	}

	@Override
	public double countAttendancePercentInCourseOffering(int courseOfferingId) {
		int sessionCount = sessionRepository.countByCourseOffering(courseOfferingId);
		int registrationCount = registryRepository.countByCourseOffering(courseOfferingId);
		int attendanceCount = attendanceRepository.countRecordsInCourseOffering(courseOfferingId);

		return ((attendanceCount * 1.0) / (sessionCount * registrationCount)) * 100;
	}

}