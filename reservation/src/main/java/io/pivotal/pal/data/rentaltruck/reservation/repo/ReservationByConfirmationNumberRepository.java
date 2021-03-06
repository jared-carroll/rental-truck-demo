package io.pivotal.pal.data.rentaltruck.reservation.repo;

import io.pivotal.pal.data.rentaltruck.reservation.entity.ReservationByConfirmationNumber;
import org.springframework.data.repository.CrudRepository;

public interface ReservationByConfirmationNumberRepository extends CrudRepository<ReservationByConfirmationNumber, String> {

    ReservationByConfirmationNumber findByConfirmationNumber(String confirmationNumber);
}
