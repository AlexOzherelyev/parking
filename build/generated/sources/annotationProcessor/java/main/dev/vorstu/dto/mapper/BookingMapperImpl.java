package dev.vorstu.dto.mapper;

import dev.vorstu.dto.BookingDto;
import dev.vorstu.entity.Booking;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T16:53:57+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public Booking dtoToEntity(BookingDto dto) {
        if ( dto == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( dto.getId() );
        booking.setParkingId( dto.getParkingId() );
        booking.setTimeBookStart( dto.getTimeBookStart() );
        booking.setTimeBookEnd( dto.getTimeBookEnd() );
        booking.setIsApproved( dto.getIsApproved() );
        booking.setUserId( dto.getUserId() );

        return booking;
    }

    @Override
    public BookingDto entityToDto(Booking entity) {
        if ( entity == null ) {
            return null;
        }

        BookingDto.BookingDtoBuilder bookingDto = BookingDto.builder();

        bookingDto.id( entity.getId() );
        bookingDto.parkingId( entity.getParkingId() );
        bookingDto.timeBookStart( entity.getTimeBookStart() );
        bookingDto.timeBookEnd( entity.getTimeBookEnd() );
        bookingDto.isApproved( entity.getIsApproved() );
        bookingDto.userId( entity.getUserId() );

        return bookingDto.build();
    }

    @Override
    public List<BookingDto> toList(List<Booking> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingDto> list1 = new ArrayList<BookingDto>( list.size() );
        for ( Booking booking : list ) {
            list1.add( entityToDto( booking ) );
        }

        return list1;
    }

    @Override
    public List<Booking> toListEntity(List<BookingDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Booking> list1 = new ArrayList<Booking>( list.size() );
        for ( BookingDto bookingDto : list ) {
            list1.add( dtoToEntity( bookingDto ) );
        }

        return list1;
    }
}
