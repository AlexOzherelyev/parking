package dev.vorstu.dto.mapper;

import dev.vorstu.dto.UserDto;
import dev.vorstu.entity.Booking;
import dev.vorstu.entity.ChatRoom;
import dev.vorstu.entity.User;
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
public class UserMapperImpl implements UserMapper {

    private final OwnerMapper ownerMapper;

    @Autowired
    public UserMapperImpl(OwnerMapper ownerMapper) {

        this.ownerMapper = ownerMapper;
    }

    @Override
    public User dtoToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setFio( dto.getFio() );
        user.setPhone( dto.getPhone() );
        user.setEmail( dto.getEmail() );
        user.setCredentialId( dto.getCredentialId() );
        user.setOwner( ownerMapper.dtoToEntity( dto.getOwner() ) );
        List<Booking> list = dto.getBooking();
        if ( list != null ) {
            user.setBooking( new ArrayList<Booking>( list ) );
        }
        List<ChatRoom> list1 = dto.getChatRoom();
        if ( list1 != null ) {
            user.setChatRoom( new ArrayList<ChatRoom>( list1 ) );
        }

        return user;
    }

    @Override
    public UserDto entityToDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setFio( entity.getFio() );
        userDto.setPhone( entity.getPhone() );
        userDto.setEmail( entity.getEmail() );
        userDto.setCredentialId( entity.getCredentialId() );
        userDto.setOwner( ownerMapper.entityToDto( entity.getOwner() ) );
        List<Booking> list = entity.getBooking();
        if ( list != null ) {
            userDto.setBooking( new ArrayList<Booking>( list ) );
        }
        List<ChatRoom> list1 = entity.getChatRoom();
        if ( list1 != null ) {
            userDto.setChatRoom( new ArrayList<ChatRoom>( list1 ) );
        }

        return userDto;
    }

    @Override
    public List<UserDto> toList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDto> list1 = new ArrayList<UserDto>( list.size() );
        for ( User user : list ) {
            list1.add( entityToDto( user ) );
        }

        return list1;
    }

    @Override
    public List<User> toListEntity(List<UserDto> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( UserDto userDto : list ) {
            list1.add( dtoToEntity( userDto ) );
        }

        return list1;
    }
}
