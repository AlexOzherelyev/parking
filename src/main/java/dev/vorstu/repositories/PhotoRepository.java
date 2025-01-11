package dev.vorstu.repositories;

import dev.vorstu.entity.Parking;
import dev.vorstu.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findAll();
}
