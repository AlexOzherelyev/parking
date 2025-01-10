package dev.vorstu.service;

import dev.vorstu.dto.BookingDto;
import dev.vorstu.dto.mapper.BookingMapper;
import dev.vorstu.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper mapper;

    public BookingDto create(BookingDto bookingDto) {
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
}
