package com.rest.server.graphql.inputs;

public class LocationInput {
    private String locationStreet;
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private String locationTimezone;

    public String getLocationStreet() {
        return locationStreet;
    }

    public void setLocationStreet(String locationStreet) {
        this.locationStreet = locationStreet;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationTimezone() {
        return locationTimezone;
    }

    public void setLocationTimezone(String locationTimezone) {
        this.locationTimezone = locationTimezone;
    }
}
