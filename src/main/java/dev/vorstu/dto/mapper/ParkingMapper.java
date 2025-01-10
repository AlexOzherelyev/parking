package dev.vorstu.dto.mapper;


import dev.vorstu.dto.ParkingDto;
import dev.vorstu.entity.Parking;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = OwnerMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ParkingMapper {
    Parking dtoToEntity(ParkingDto dto);

    ParkingDto entityToDto(Parking entity);

    List<ParkingDto> toList(List<Parking> list);

    List<Parking> toListEntity(List<ParkingDto> list);
}
