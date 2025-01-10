package dev.vorstu.dto.mapper;

import dev.vorstu.dto.OwnerDto;
import dev.vorstu.entity.ChatRoom;
import dev.vorstu.entity.Owner;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-10T19:13:28+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    private final ParkingMapper parkingMapper;

    @Autowired
    public OwnerMapperImpl(ParkingMapper parkingMapper) {

        this.parkingMapper = parkingMapper;
    }

    @Override
    public Owner dtoToEntity(OwnerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setId( dto.getId() );
        owner.setIsApproved( dto.getIsApproved() );
        owner.setUserId( dto.getUserId() );
        owner.setParking( parkingMapper.toListEntity( dto.getParking() ) );
        List<ChatRoom> list1 = dto.getChatRoom();
        if ( list1 != null ) {
            owner.setChatRoom( new ArrayList<ChatRoom>( list1 ) );
        }

        return owner;
    }

    @Override
    public OwnerDto entityToDto(Owner entity) {
        if ( entity == null ) {
            return null;
        }

        OwnerDto ownerDto = new OwnerDto();

        ownerDto.setId( entity.getId() );
        ownerDto.setIsApproved( entity.getIsApproved() );
        ownerDto.setUserId( entity.getUserId() );
        ownerDto.setParking( parkingMapper.toList( entity.getParking() ) );
        List<ChatRoom> list1 = entity.getChatRoom();
        if ( list1 != null ) {
            ownerDto.setChatRoom( new ArrayList<ChatRoom>( list1 ) );
        }

        return ownerDto;
    }

    @Override
    public List<OwnerDto> toList(List<Owner> list) {
        if ( list == null ) {
            return null;
        }

        List<OwnerDto> list1 = new ArrayList<OwnerDto>( list.size() );
        for ( Owner owner : list ) {
            list1.add( entityToDto( owner ) );
        }

        return list1;
    }

    @Override
    public List<Owner> toListEntity(List<OwnerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Owner> list1 = new ArrayList<Owner>( list.size() );
        for ( OwnerDto ownerDto : list ) {
            list1.add( dtoToEntity( ownerDto ) );
        }

        return list1;
    }
}
