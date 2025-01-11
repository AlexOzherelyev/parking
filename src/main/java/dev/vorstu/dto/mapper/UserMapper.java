package dev.vorstu.dto.mapper;


import dev.vorstu.dto.UserDto;
import dev.vorstu.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookingMapper.class,OwnerMapper.class, CredentialMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    User dtoToEntity(UserDto dto);

    UserDto entityToDto(User entity);

    List<UserDto> toList(List<User> list);

    List<User> toListEntity(List<UserDto> list);

}
