package attendance.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@AllArgsConstructor
@Entity
public class Session {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "courseOfferingId")
	@Valid
	@NotNull
	private CourseOffering courseOffering;

	@ManyToOne
	@JoinColumn(name = "timeSlotId")
	@Valid
	@NotNull
	private Timeslot timeslot;

	@NotNull
	private LocalDate date;
	
	public  Session() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseOffering getCourseOffering() {
		return courseOffering;
	}

	public void setCourseOffering(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
