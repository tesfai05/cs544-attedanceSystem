package attendance.demo.controller;

import attendance.demo.domain.Administrator;
import attendance.demo.domain.Course;
import attendance.demo.service.administrator.AdministratorService;
import attendance.demo.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("admin/admins")
    public List<Administrator> getAllAdmins() {
        return administratorService.findAll();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/admins/{id}")
    public Optional getAdmin(@PathVariable Integer id){
        return administratorService.findById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/admins")
    public Administrator addAdmin(@RequestBody Administrator administrator){
        return administratorService.save(administrator);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/admin/admins")
    public Administrator updateAdmin(@RequestBody Administrator administrator){
        return administratorService.save(administrator);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value ="/admin/admins/{id}")
    public void deleteAdmin(@PathVariable Integer id){
        administratorService.delete(id);
    }
}
