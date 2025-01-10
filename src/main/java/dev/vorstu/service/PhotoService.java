package dev.vorstu.service;

import dev.vorstu.dto.PhotoDto;
import dev.vorstu.dto.mapper.PhotoMapper;
import dev.vorstu.repositories.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final PhotoMapper mapper;

    public PhotoDto create(PhotoDto photoDto) {
        return mapper.entityToDto(
                photoRepository.save(mapper.dtoToEntity(photoDto))
        );
    }

    public PhotoDto update(PhotoDto photoDto) {
        return mapper.entityToDto(
                photoRepository.save(mapper.dtoToEntity(photoDto))
        );
    }

    public Long delete(Long id) {
        photoRepository.deleteById(id);
        return id;
    }

    public List<PhotoDto> findAll() {
        return mapper.toList(
                photoRepository.findAll());
    }
}
