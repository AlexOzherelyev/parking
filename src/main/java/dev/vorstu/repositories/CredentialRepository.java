package dev.vorstu.repositories;

import dev.vorstu.dto.CredentialDto;
import dev.vorstu.entity.ChatRoom;
import dev.vorstu.entity.Credential;
import dev.vorstu.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CredentialRepository extends CrudRepository<Credential, Long> {
    List<Credential> findAll();
    Optional<Credential> findByUsername(String username);
    boolean existsByUsername(String username);
}
