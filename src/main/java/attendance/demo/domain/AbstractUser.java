package attendance.demo.domain;

import lombok.AllArgsConstructor;
import javax.persistence.*;



@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class AbstractUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    protected String username;

    protected String password;

    public AbstractUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
