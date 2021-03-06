package io.pivotal.pal.data.rentaltruck.reservation.query.pickupstore;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@RestController
public class StoreByLocationAndDateAndTruckTypeQueryController {

    private final StoreByLocationAndDateAndTruckTypeQueryRepository repository;

    public StoreByLocationAndDateAndTruckTypeQueryController(StoreByLocationAndDateAndTruckTypeQueryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stores")
    public Collection<StoreByLocationAndDateAndTruckTypeProjection> findStoresByLocationAndDateAndTruckType(@RequestParam String city,
                                                                                                            @RequestParam String state,
                                                                                                            @RequestParam @DateTimeFormat(iso = DATE) LocalDate pickupDate,
                                                                                                            @RequestParam String truckType) {

        return repository.findAllProjectedByLocationAndDateAndTruckType(city, state, pickupDate, truckType);
    }
}
