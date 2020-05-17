package attendance.demo.service.session;


import attendance.demo.domain.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<Session> findAll();
    Optional findById(int id);
    Session save(Session session);
    void delete(int id);
}
