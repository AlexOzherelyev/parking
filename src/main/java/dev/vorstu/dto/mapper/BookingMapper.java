package dev.vorstu.dto.mapper;

import dev.vorstu.dto.BookingDto;
import dev.vorstu.entity.Booking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking dtoToEntity(BookingDto dto);

    BookingDto entityToDto(Booking entity);

    List<BookingDto> toList(List<Booking> list);

    List<Booking> toListEntity(List<BookingDto> list);
}
