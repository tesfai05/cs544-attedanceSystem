package attendance.demo.service.location;

import attendance.demo.domain.Location;
import attendance.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepository locationRepository;


    public Location addLocation(Location location) {
        locationRepository.saveAndFlush(location);
        return location;
    }
    public Location updateLocation(Location location) {
        locationRepository.saveAndFlush(location);
        return location;
    }
    public boolean deleteLocationById(int id) {
        locationRepository.deleteById(id);
        return true;
    }
    public Location getLocationById(int id) {
        Optional<Location> opt= locationRepository.findById(id);
        return opt.get();
    }
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
