package com.rest.server.graphql.resolvers;

import com.rest.server.models.Location;
import com.rest.server.graphql.inputss.LocationInput;
import com.rest.server.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LocationMutationResolver {

    @Autowired
    private LocationService locationService;

    @MutationMapping
    public Location createLocation(@Argument LocationInput input) {
        Location location = new Location();
        location.setLocationStreet(input.getLocationStreet());
        location.setLocationCity(input.getLocationCity());
        location.setLocationState(input.getLocationState());
        location.setLocationCountry(input.getLocationCountry());
        location.setLocationTimezone(input.getLocationTimezone());

        return locationService.createLocation(location);
    }

    @MutationMapping
    public Location updateLocation(@Argument String id, @Argument LocationInput input) {
        Location existing = locationService.singleLocation(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        Location updated = new Location();
        updated.setLocationStreet(input.getLocationStreet());
        updated.setLocationCity(input.getLocationCity());
        updated.setLocationState(input.getLocationState());
        updated.setLocationCountry(input.getLocationCountry());
        updated.setLocationTimezone(input.getLocationTimezone());

        return locationService.updateLocation(id, updated);
    }

    @MutationMapping
    public String deleteLocation(@Argument String id) {
        locationService.deleteLocation(id);
        return id;
    }
}
