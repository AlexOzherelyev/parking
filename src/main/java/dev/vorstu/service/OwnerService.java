package dev.vorstu.service;

import dev.vorstu.dto.OwnerDto;
import dev.vorstu.dto.mapper.OwnerMapper;
import dev.vorstu.entity.Owner;
import dev.vorstu.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper mapper;

    public OwnerDto create(OwnerDto ownerDto) {
        return mapper.entityToDto(
                ownerRepository.save(mapper.dtoToEntity(ownerDto))
        );
    }

    public OwnerDto update(OwnerDto ownerDto) {
        return mapper.entityToDto(
                ownerRepository.save(mapper.dtoToEntity(ownerDto))
        );
    }

    public Long delete(Long id) {
        ownerRepository.deleteById(id);
        return id;
    }

    public List<OwnerDto> findAll() {
        return mapper.toList(
                ownerRepository.findAll());
    }

    public Optional<OwnerDto> findById(Long id) {
        Owner entity = ownerRepository.findById(id).orElse(null);
        if (entity != null) {
            return Optional.of(mapper.entityToDto(entity));
        } else {
            return Optional.empty();
        }
    }
}
