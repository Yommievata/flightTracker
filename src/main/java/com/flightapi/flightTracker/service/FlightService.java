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

    /**
     * Sends a request for a round trip flight using the specified parameters.
     *
     * @param  apiKey        the API key for authentication
     * @param  origin        the origin airport code
     * @param  destination   the destination airport code
     * @param  departureDate the departure date in the format "YYYY-MM-DD"
     * @param  returnDate    the return date in the format "YYYY-MM-DD"
     * @param  adults        the number of adult passengers
     * @param  children      the number of child passengers
     * @param  infants       the number of infant passengers
     * @param  cabinClass    the cabin class for the flight
     * @param  currency      the currency for the pricing
     * @return               the response from the API as a String
     */
    public String roundTrip(String apiKey, String origin, String destination, String departureDate, String returnDate,
                            int adults, int children, int infants, String cabinClass, String currency) {
        String roundTripUrl = apiUrl + "roundtrip/" + apiKey + "/" + origin + "/" + destination + "/"
                + departureDate + "/" + returnDate + "/" + adults + "/" + children + "/" + infants + "/"
                + cabinClass + "/" + currency;

        return restTemplate.getForObject(roundTripUrl, String.class);
    }

    /**
     * Sends a request for a one-way trip using the provided API key, origin, destination, departure date,
     * number of adults, children, infants, cabin class, and currency.
     *
     * @param  apiKey         the API key for authentication
     * @param  origin         the origin airport code
     * @param  destination    the destination airport code
     * @param  departureDate  the date of departure in the format "YYYY-MM-DD"
     * @param  adults         the number of adult passengers
     * @param  children       the number of child passengers
     * @param  infants        the number of infant passengers
     * @param  cabinClass     the cabin class for the trip
     * @param  currency       the currency for the trip
     * @return                the response from the API as a String
     */
    public String oneWayTrip(String apiKey, String origin, String destination, String departureDate,
                             int adults, int children, int infants, String cabinClass, String currency) {
        String oneWayTripUrl = apiUrl + "onewaytrip/" + apiKey + "/" + origin + "/" + destination + "/"
                + departureDate + "/" + adults + "/" + children + "/" + infants + "/"
                + cabinClass + "/" + currency;

        return restTemplate.getForObject(oneWayTripUrl, String.class);
    }
}
