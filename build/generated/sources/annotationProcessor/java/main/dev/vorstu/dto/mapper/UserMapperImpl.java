package dev.vorstu.dto.mapper;

import dev.vorstu.dto.UserDto;
import dev.vorstu.entity.ChatRoom;
import dev.vorstu.entity.User;
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
public class UserMapperImpl implements UserMapper {

    private final BookingMapper bookingMapper;
    private final OwnerMapper ownerMapper;

    @Autowired
    public UserMapperImpl(BookingMapper bookingMapper, OwnerMapper ownerMapper) {

        this.bookingMapper = bookingMapper;
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
        user.setBooking( bookingMapper.toListEntity( dto.getBooking() ) );
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

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( entity.getId() );
        userDto.fio( entity.getFio() );
        userDto.phone( entity.getPhone() );
        userDto.email( entity.getEmail() );
        userDto.credentialId( entity.getCredentialId() );
        userDto.owner( ownerMapper.entityToDto( entity.getOwner() ) );
        userDto.booking( bookingMapper.toList( entity.getBooking() ) );
        List<ChatRoom> list1 = entity.getChatRoom();
        if ( list1 != null ) {
            userDto.chatRoom( new ArrayList<ChatRoom>( list1 ) );
        }

        return userDto.build();
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
