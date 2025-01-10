package dev.vorstu.repositories;

import dev.vorstu.entity.Credential;
import dev.vorstu.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAll();
}
