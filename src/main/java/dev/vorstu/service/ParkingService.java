package dev.vorstu.service;

import dev.vorstu.dto.ParkingDto;
import dev.vorstu.dto.mapper.ParkingMapper;
import dev.vorstu.entity.Credential;
import dev.vorstu.repositories.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final ParkingMapper mapper;
    private final CredentialService credentialService;

    public ParkingDto create(ParkingDto parkingDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentUserName = authentication.getName();
            Credential currentUser = credentialService.getByUsername(currentUserName);
            parkingDto.setOwnerId(currentUser.getUser().getOwner().getId());
        }
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

    public List<ParkingDto> findForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentUserName = authentication.getName();
            Credential currentUser = credentialService.getByUsername(currentUserName);
            Long ownerId = currentUser.getUser().getOwner().getId();
            return mapper.toList(parkingRepository.findByOwnerId(ownerId));
        }
        return Collections.emptyList(); // Возвращаем пустой список, если текущий пользователь не найден
    }
}
