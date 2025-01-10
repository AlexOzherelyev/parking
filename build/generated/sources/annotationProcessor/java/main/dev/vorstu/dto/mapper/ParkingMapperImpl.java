package dev.vorstu.dto.mapper;

import dev.vorstu.dto.ParkingDto;
import dev.vorstu.entity.Parking;
import dev.vorstu.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-10T19:13:28+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class ParkingMapperImpl implements ParkingMapper {

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
        parking.setBooking( dto.getBooking() );
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

        ParkingDto parkingDto = new ParkingDto();

        parkingDto.setId( entity.getId() );
        parkingDto.setAddress( entity.getAddress() );
        parkingDto.setCode( entity.getCode() );
        parkingDto.setPrice( entity.getPrice() );
        parkingDto.setTimeStart( entity.getTimeStart() );
        parkingDto.setTimeEnd( entity.getTimeEnd() );
        parkingDto.setOwnerId( entity.getOwnerId() );
        parkingDto.setBooking( entity.getBooking() );
        List<Photo> list = entity.getPhoto();
        if ( list != null ) {
            parkingDto.setPhoto( new ArrayList<Photo>( list ) );
        }

        return parkingDto;
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
