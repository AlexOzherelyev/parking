package dev.vorstu.repositories;

import dev.vorstu.entity.Parking;
import dev.vorstu.entity.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
    List<Photo> findAll();
}
