package com.flightapi.flightTracker.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightService {

    @Value("${flight.api.key}")
    private String apiKey;

    @Value("${flight.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public FlightService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String roundTrip(String apiKey, String origin, String destination, String departureDate, String returnDate,
                            int adults, int children, int infants, String cabinClass, String currency) {
        String roundTripUrl = apiUrl + "roundtrip/" + apiKey + "/" + origin + "/" + destination + "/"
                + departureDate + "/" + returnDate + "/" + adults + "/" + children + "/" + infants + "/"
                + cabinClass + "/" + currency;

        return restTemplate.getForObject(roundTripUrl, String.class);
    }

    public String oneWayTrip(String apiKey, String origin, String destination, String departureDate,
                             int adults, int children, int infants, String cabinClass, String currency) {
        String oneWayTripUrl = apiUrl + "onewaytrip/" + apiKey + "/" + origin + "/" + destination + "/"
                + departureDate + "/" + adults + "/" + children + "/" + infants + "/"
                + cabinClass + "/" + currency;

        return restTemplate.getForObject(oneWayTripUrl, String.class);
    }
}
