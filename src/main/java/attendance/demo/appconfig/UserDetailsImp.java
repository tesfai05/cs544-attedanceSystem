package attendance.demo.appconfig;

import attendance.demo.domain.AbstractUser;
import attendance.demo.domain.Administrator;
import attendance.demo.domain.Faculty;
import attendance.demo.domain.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailsImp implements UserDetails {

    private AbstractUser systemUser;

    public UserDetailsImp(AbstractUser systemUser) {
        this.systemUser = systemUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> student = new ArrayList<>();
        student.add(new SimpleGrantedAuthority("USER"));

        List<GrantedAuthority> faculty = new ArrayList<>();
        faculty.add(new SimpleGrantedAuthority("ROLE_FACULTY"));

        List<GrantedAuthority> administratorRoles = new ArrayList<>();
        administratorRoles.add(new SimpleGrantedAuthority("ROLE_FACULTY"));
        administratorRoles.add(new SimpleGrantedAuthority("USER"));
        administratorRoles.add(new SimpleGrantedAuthority("ADMIN"));

        Map<String, List<GrantedAuthority>> user = new HashMap<>();
        user.put("student", student);
        user.put("faculty", faculty);
        user.put("admin", administratorRoles);

        List<GrantedAuthority> abstractUser = null;

        if (systemUser instanceof Student){
            abstractUser = user.get("student");
        }
        else if (systemUser instanceof Faculty){
            abstractUser = user.get("faculty");
        }
        else if(systemUser instanceof Administrator){
            abstractUser = user.get("admin");
        }
        return abstractUser;
    }

    @Override
    public String getPassword() {
        return systemUser.getPassword();
    }

    @Override
    public String getUsername() {
        return systemUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
