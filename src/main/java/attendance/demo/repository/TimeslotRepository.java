package attendance.demo.repository;

import attendance.demo.domain.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attendance.demo.domain.AttendanceRecord;
import attendance.demo.domain.Timeslot;

import javax.transaction.Transactional;

@Repository
@Transactional()
public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {
}