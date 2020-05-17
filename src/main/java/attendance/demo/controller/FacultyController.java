package attendance.demo.controller;

import attendance.demo.domain.Faculty;
import attendance.demo.service.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FacultyController{

    @Autowired
    private FacultyService facultyService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("admin/faculties")
    public List<Faculty> getAllFaculty() {
        return facultyService.findAll();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/faculties/{id}")
    public Optional getFaculty(@PathVariable Integer id){
        return facultyService.findById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/faculties")
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.save(faculty);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/admin/faculties")
    public Faculty updateFaculty(@RequestBody Faculty faculty){
        return facultyService.save(faculty);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value ="/admin/faculties/{id}")
    public void deleteFaculty(@PathVariable Integer id){
        facultyService.delete(id);
    }

}
