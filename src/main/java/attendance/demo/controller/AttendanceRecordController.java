package attendance.demo.controller;
import java.util.List;
import attendance.demo.domain.AttendanceRecord;
import attendance.demo.domain.Course;
import attendance.demo.domain.CourseOffering;
import attendance.demo.service.course.CourseService;
import attendance.demo.service.attendance.AttendanceService;
import attendance.demo.service.courseOffering.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceRecordController {

    @Autowired
    private AttendanceService attendanceService;

    @PreAuthorize("hasAuthority('ROLE_FACULTY')")
    @GetMapping(value = "/faculty/attendance/student/{studentid}/courseoffering/{offeringid}")
    public List<AttendanceRecord> getStudentRecordsInCourseOffering(@PathVariable("studentid") String studentId,
                                                                    @PathVariable("offeringid") int courseOfferingId) {
        List<AttendanceRecord> result = attendanceService.getStudentRecordsInCourseOffering(studentId,
                courseOfferingId);
        return result;
    }

    @PreAuthorize("hasAuthority('ROLE_FACULTY')")
    @GetMapping(value = "/faculty/attendance/session/{sessionid}")
    public List<AttendanceRecord> getSessionRecords(@PathVariable("sessionid") int sessionId) {
        List<AttendanceRecord> result = attendanceService.getSessionRecords(sessionId);
        return result;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value="students")
    public List<AttendanceRecord> getStudentAttendance(@PathVariable String studentId){
        return attendanceService.getStudentAttendance(studentId);
    }
}