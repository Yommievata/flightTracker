package com.flightapi.flightTracker.controller;

import com.flightapi.flightTracker.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Retrieves round trip flight information.
     *
     * @param  origin         the origin airport code
     * @param  destination    the destination airport code
     * @param  departureDate  the departure date
     * @param  returnDate     the return date
     * @param  adults         the number of adult passengers
     * @param  children       the number of child passengers
     * @param  infants        the number of infant passengers
     * @param  cabinClass     the cabin class
     * @param  currency       the currency for pricing
     * @return                the round trip flight information
     */
    @GetMapping("/roundtrip")
    public String roundTrip(@RequestParam String apiKey, @RequestParam String origin, @RequestParam String destination,
                            @RequestParam String departureDate, @RequestParam String returnDate,
                            @RequestParam int adults, @RequestParam int children,
                            @RequestParam int infants, @RequestParam String cabinClass,
                            @RequestParam String currency) {
        return flightService.roundTrip(apiKey, origin, destination, departureDate, returnDate,
                adults, children, infants, cabinClass, currency);
    }

    /**
     * A method to handle a one way trip request.
     *
     * @param  origin         the origin airport or city
     * @param  destination    the destination airport or city
     * @param  departureDate  the date of departure
     * @param  adults         number of adult passengers
     * @param  children       number of child passengers
     * @param  infants        number of infant passengers
     * @param  cabinClass     the cabin class for the trip
     * @param  currency       the currency for the transaction
     * @return                the result of the one way trip request
     */
    @GetMapping("/onewaytrip")
    public String oneWayTrip(@RequestParam String apiKey, @RequestParam String origin, @RequestParam String destination,
                             @RequestParam String departureDate, @RequestParam int adults,
                             @RequestParam int children, @RequestParam int infants,
                             @RequestParam String cabinClass, @RequestParam String currency) {
        return flightService.oneWayTrip(apiKey, origin, destination, departureDate,
                adults, children, infants, cabinClass, currency);
    }
}