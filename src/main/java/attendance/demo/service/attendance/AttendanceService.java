package attendance.demo.service.attendance;
import attendance.demo.domain.AttendanceRecord;

import java.util.List;


public interface AttendanceService {

    List<AttendanceRecord> getSessionRecords(int sessionId);

    List<AttendanceRecord> getStudentRecordsInCourseOffering(String studentId, int courseOfferingId);
    List<AttendanceRecord> getStudentAttendance(String studentId);
}
