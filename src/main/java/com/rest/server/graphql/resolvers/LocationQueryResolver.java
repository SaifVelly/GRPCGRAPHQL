package com.rest.server.graphql.resolvers;

import com.rest.server.models.Location;
import com.rest.server.graphql.inputs.LocationPage;
import com.rest.server.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LocationQueryResolver {

    @Autowired
    private LocationService locationService;

    @QueryMapping
    public LocationPage getAllLocations(@Argument int page, @Argument int size) {
        Page<Location> locations = locationService.allLocations(PageRequest.of(page, size));
        return new LocationPage(locations.getContent(), locations.getTotalElements(), page, size);
    }

    @QueryMapping
    public Location getSingleLocation(@Argument String id) {
        return locationService.singleLocation(id).orElse(null);
    }
}
