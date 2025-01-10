package dev.vorstu.dto.mapper;


import dev.vorstu.dto.PhotoDto;
import dev.vorstu.entity.Photo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {

    Photo dtoToEntity(PhotoDto dto);

    PhotoDto entityToDto(Photo entity);

    List<PhotoDto> toList(List<Photo> list);

    List<Photo> toListEntity(List<PhotoDto> list);
}
