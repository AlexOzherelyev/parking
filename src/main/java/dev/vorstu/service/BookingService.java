package dev.vorstu.service;

import dev.vorstu.dto.BookingDto;
import dev.vorstu.dto.mapper.BookingMapper;
import dev.vorstu.entity.Credential;
import dev.vorstu.repositories.BookingRepository;
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
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper mapper;
    private final CredentialService credentialService;

    public BookingDto create(BookingDto bookingDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentUserName = authentication.getName();
            Credential currentUser = credentialService.getByUsername(currentUserName);
            bookingDto.setUserId(currentUser.getUser().getId());
        }
        return mapper.entityToDto(
                bookingRepository.save(mapper.dtoToEntity(bookingDto))
        );
    }

    public BookingDto update(BookingDto bookingDto) {
        return mapper.entityToDto(
                bookingRepository.save(mapper.dtoToEntity(bookingDto))
        );
    }

    public Long delete(Long id) {
        bookingRepository.deleteById(id);
        return id;
    }

    public List<BookingDto> findAll() {
        return mapper.toList(
                bookingRepository.findAll());
    }

    public List<BookingDto> findForCurrentUser(){
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
