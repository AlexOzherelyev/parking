package dev.vorstu.service;

import dev.vorstu.dto.ParkingDto;
import dev.vorstu.dto.mapper.ParkingMapper;
import dev.vorstu.repositories.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final ParkingMapper mapper;

    public ParkingDto create(ParkingDto parkingDto) {
        return mapper.entityToDto(
                parkingRepository.save(mapper.dtoToEntity(parkingDto))
        );
    }

    public ParkingDto update(ParkingDto parkingDto) {
        return mapper.entityToDto(
                parkingRepository.save(mapper.dtoToEntity(parkingDto))
        );
    }

    public Long delete(Long id) {
        parkingRepository.deleteById(id);
        return id;
    }

    public List<ParkingDto> findAll() {
        return mapper.toList(
                parkingRepository.findAll());
    }

}
