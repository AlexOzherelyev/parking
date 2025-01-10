package dev.vorstu.service;

import dev.vorstu.dto.OwnerDto;
import dev.vorstu.dto.UserDto;
import dev.vorstu.dto.mapper.UserMapper;
import dev.vorstu.entity.Owner;
import dev.vorstu.entity.User;
import dev.vorstu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserDto create(UserDto userDto) {
        return mapper.entityToDto(
                userRepository.save(mapper.dtoToEntity(userDto))
        );
    }

    public UserDto update(UserDto userDto) {
        return mapper.entityToDto(
                userRepository.save(mapper.dtoToEntity(userDto))
        );
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    public List<UserDto> findAll() {
        return mapper.toList(
                userRepository.findAll());
    }

    public Optional<UserDto> findById(Long id) {
        User entity = userRepository.findById(id).orElse(null);
        if (entity != null) {
            return Optional.of(mapper.entityToDto(entity));
        } else {
            return Optional.empty();
        }
    }
}
