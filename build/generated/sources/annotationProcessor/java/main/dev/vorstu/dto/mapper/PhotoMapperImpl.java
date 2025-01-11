package dev.vorstu.dto.mapper;

import dev.vorstu.dto.PhotoDto;
import dev.vorstu.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T14:11:10+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public Photo dtoToEntity(PhotoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Photo photo = new Photo();

        photo.setId( dto.getId() );
        photo.setImage( dto.getImage() );
        photo.setParking( dto.getParking() );

        return photo;
    }

    @Override
    public PhotoDto entityToDto(Photo entity) {
        if ( entity == null ) {
            return null;
        }

        PhotoDto photoDto = new PhotoDto();

        photoDto.setId( entity.getId() );
        photoDto.setImage( entity.getImage() );
        photoDto.setParking( entity.getParking() );

        return photoDto;
    }

    @Override
    public List<PhotoDto> toList(List<Photo> list) {
        if ( list == null ) {
            return null;
        }

        List<PhotoDto> list1 = new ArrayList<PhotoDto>( list.size() );
        for ( Photo photo : list ) {
            list1.add( entityToDto( photo ) );
        }

        return list1;
    }

    @Override
    public List<Photo> toListEntity(List<PhotoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Photo> list1 = new ArrayList<Photo>( list.size() );
        for ( PhotoDto photoDto : list ) {
            list1.add( dtoToEntity( photoDto ) );
        }

        return list1;
    }
}
