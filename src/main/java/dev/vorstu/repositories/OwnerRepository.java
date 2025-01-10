package dev.vorstu.repositories;

import dev.vorstu.entity.Message;
import dev.vorstu.entity.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    List<Owner> findAll();
}
