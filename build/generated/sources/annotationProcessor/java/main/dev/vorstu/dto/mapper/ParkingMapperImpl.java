package dev.vorstu.dto.mapper;

import dev.vorstu.dto.ParkingDto;
import dev.vorstu.entity.Parking;
import dev.vorstu.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T16:53:57+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class ParkingMapperImpl implements ParkingMapper {

    private final BookingMapper bookingMapper;

    @Autowired
    public ParkingMapperImpl(BookingMapper bookingMapper) {

        this.bookingMapper = bookingMapper;
    }

    @Override
    public Parking dtoToEntity(ParkingDto dto) {
        if ( dto == null ) {
            return null;
        }

        Parking parking = new Parking();

        parking.setId( dto.getId() );
        parking.setAddress( dto.getAddress() );
        parking.setCode( dto.getCode() );
        parking.setPrice( dto.getPrice() );
        parking.setTimeStart( dto.getTimeStart() );
        parking.setTimeEnd( dto.getTimeEnd() );
        parking.setOwnerId( dto.getOwnerId() );
        parking.setBooking( bookingMapper.dtoToEntity( dto.getBooking() ) );
        List<Photo> list = dto.getPhoto();
        if ( list != null ) {
            parking.setPhoto( new ArrayList<Photo>( list ) );
        }

        return parking;
    }

    @Override
    public ParkingDto entityToDto(Parking entity) {
        if ( entity == null ) {
            return null;
        }

        ParkingDto.ParkingDtoBuilder parkingDto = ParkingDto.builder();

        parkingDto.id( entity.getId() );
        parkingDto.address( entity.getAddress() );
        parkingDto.code( entity.getCode() );
        parkingDto.price( entity.getPrice() );
        parkingDto.timeStart( entity.getTimeStart() );
        parkingDto.timeEnd( entity.getTimeEnd() );
        parkingDto.ownerId( entity.getOwnerId() );
        parkingDto.booking( bookingMapper.entityToDto( entity.getBooking() ) );
        List<Photo> list = entity.getPhoto();
        if ( list != null ) {
            parkingDto.photo( new ArrayList<Photo>( list ) );
        }

        return parkingDto.build();
    }

    @Override
    public List<ParkingDto> toList(List<Parking> list) {
        if ( list == null ) {
            return null;
        }

        List<ParkingDto> list1 = new ArrayList<ParkingDto>( list.size() );
        for ( Parking parking : list ) {
            list1.add( entityToDto( parking ) );
        }

        return list1;
    }

    @Override
    public List<Parking> toListEntity(List<ParkingDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Parking> list1 = new ArrayList<Parking>( list.size() );
        for ( ParkingDto parkingDto : list ) {
            list1.add( dtoToEntity( parkingDto ) );
        }

        return list1;
    }
}
