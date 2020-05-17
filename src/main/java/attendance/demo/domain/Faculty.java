package attendance.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Entity
public class Faculty extends AbstractUser{


	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	public Faculty() {
		
	}
	
	  @Override
	  public int getId() {
	    return super.getId();
	  }
	
	  @Override
	  public String getUsername() {
	    return super.getUsername();
	  }
	
	  @Override
	  public void setUsername(String username) {
	    super.setUsername(username);
	  }
	
	  @Override
	  public String getPassword() {
	    return super.getPassword();
	  }
	
	  @Override
	  public void setPassword(String password) {
	    super.setPassword(password);
	  }
	
	  @Override
	  public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Faculty faculty = (Faculty) o;
	    return firstName.equals(faculty.firstName) &&
	            lastName.equals(faculty.lastName);
	  }
	
	  @Override
	  public int hashCode() {
	    return Objects.hash(firstName, lastName);
	  }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
