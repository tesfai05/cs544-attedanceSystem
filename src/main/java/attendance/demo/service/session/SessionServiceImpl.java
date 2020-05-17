package attendance.demo.service.session;


import attendance.demo.domain.Session;
import attendance.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {


    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Optional findById(int id) {
        return sessionRepository.findById(id);
    }

    @Override
    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void delete(int id) {
        sessionRepository.deleteById(id);
    }
}
