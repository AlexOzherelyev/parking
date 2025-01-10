package dev.vorstu.repositories;

import dev.vorstu.entity.Owner;
import dev.vorstu.entity.Parking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingRepository extends CrudRepository<Parking, Long> {
    List<Parking> findAll();
}
