package dev.vorstu.dto.mapper;


import dev.vorstu.dto.OwnerDto;
import dev.vorstu.entity.Owner;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ParkingMapper.class,  UserMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OwnerMapper {

    Owner dtoToEntity(OwnerDto dto);

    OwnerDto entityToDto(Owner entity);

    List<OwnerDto> toList(List<Owner> list);

    List<Owner> toListEntity(List<OwnerDto> list);

}

