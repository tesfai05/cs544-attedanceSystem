package attendance.demo.controller;

import java.util.List;

import attendance.demo.domain.Location;
import attendance.demo.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
public class LocationController {
	@Autowired
	private LocationService locationService;

	@PreAuthorize("hasAnyAuthority('ADMIN','ROLE_FACULTY')")
	@GetMapping(value="/locations")
	@Secured({"ROLE_ADMIN","ROLE_FACULTY"})
	public List<Location> getAllLocations() {
		return locationService.getAllLocations();

	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value="/locations")
	@Secured({"ROLE_ADMIN"})
	public Location addLocation(@RequestBody Location location, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Error! Checkout your entries please ! ");
		}
		return locationService.addLocation(location);
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','ROLE_FACULTY')")
	@GetMapping(value="/locations/{id}")
	@Secured({"ROLE_ADMIN","ROLE_FACULTY"})
	public Location getLocation(@PathVariable Integer id) {
		return locationService.getLocationById(id);

	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping(value="/locations")
	public Location updateLocation(@RequestBody @Valid Location location, BindingResult result ) {
		if(result.hasErrors()) {
			System.out.println("Error! Checkout your entries please ! ");
		}
		return locationService.updateLocation(location);

	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping(value="/locations/{id}")
	public boolean deleteLocation(@PathVariable Integer id) {
		return  locationService.deleteLocationById(id);

	}
}
