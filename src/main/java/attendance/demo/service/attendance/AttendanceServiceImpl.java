package attendance.demo.service.attendance;

import attendance.demo.domain.AttendanceRecord;
import attendance.demo.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<AttendanceRecord> getSessionRecords(int sessionId) {
        return attendanceRepository.getSessionRecords(sessionId);
    }

    @Override
    public List<AttendanceRecord> getStudentRecordsInCourseOffering(String studentId, int courseOfferingId) {
        return attendanceRepository.getStudentRecordsInCourseOffering(studentId, courseOfferingId);
    }

    @Override
    public List<AttendanceRecord> getStudentAttendance(String studentId) {
        return attendanceRepository.getStudentAttendance(studentId);
    }
}
