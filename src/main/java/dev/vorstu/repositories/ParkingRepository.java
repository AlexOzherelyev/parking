package dev.vorstu.repositories;

import dev.vorstu.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
    List<Parking> findAll();
    List<Parking> findByOwnerId(Long ownerId);
}
