package attendance.demo.service.location;

import attendance.demo.domain.Location;

import java.util.List;

public interface LocationService {
    public boolean deleteLocationById(int id);

    public Location getLocationById(int id);

    public Location addLocation(Location location);

    public Location updateLocation(Location location);

    List<Location> getAllLocations();
}
