package attendance.demo.controller;


import attendance.demo.domain.Session;
import attendance.demo.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("admin/sessions")
    public List<Session> getAllSessions() {
        System.out.println("Controller");
        return sessionService.findAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/sessions/{id}")
    public Optional getSession(@PathVariable Integer id){
        return sessionService.findById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/sessions")
    public Session saveSession(@RequestBody Session session){
        return sessionService.save(session);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/admin/sessions")
    public Session updateCourse(@RequestBody Session session){
        return sessionService.save(session);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value ="/admin/sessions/{id}")
    public void deleteCourse(@PathVariable Integer id){
        sessionService.delete(id);
    }
}
