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
public class CourseOffering {
	@Id
	@GeneratedValue
	private int courseOfferingId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseId")
	@Valid
	@NotNull
	private Course course;

	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId")
	@Valid
	@NotNull
	private Location location;

	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	private Faculty faculty;
	
	public  CourseOffering() {
		
	}

	public int getCourseOfferingId() {
		return courseOfferingId;
	}

	public void setCourseOfferingId(int courseOfferingId) {
		this.courseOfferingId = courseOfferingId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	
	

}
