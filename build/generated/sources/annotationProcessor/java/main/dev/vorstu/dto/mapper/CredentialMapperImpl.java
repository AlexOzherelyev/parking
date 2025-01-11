package dev.vorstu.dto.mapper;

import dev.vorstu.dto.CredentialDto;
import dev.vorstu.entity.Credential;
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
public class CredentialMapperImpl implements CredentialMapper {

    private final UserMapper userMapper;

    @Autowired
    public CredentialMapperImpl(UserMapper userMapper) {

        this.userMapper = userMapper;
    }

    @Override
    public Credential dtoToEntity(CredentialDto dto) {
        if ( dto == null ) {
            return null;
        }

        Credential.CredentialBuilder credential = Credential.builder();

        credential.id( dto.getId() );
        credential.username( dto.getUsername() );
        credential.password( dto.getPassword() );
        credential.role( dto.getRole() );
        credential.user( userMapper.dtoToEntity( dto.getUser() ) );

        return credential.build();
    }

    @Override
    public CredentialDto entityToDto(Credential entity) {
        if ( entity == null ) {
            return null;
        }

        CredentialDto.CredentialDtoBuilder credentialDto = CredentialDto.builder();

        credentialDto.id( entity.getId() );
        credentialDto.username( entity.getUsername() );
        credentialDto.password( entity.getPassword() );
        credentialDto.role( entity.getRole() );
        credentialDto.user( userMapper.entityToDto( entity.getUser() ) );

        return credentialDto.build();
    }

    @Override
    public List<CredentialDto> toList(List<Credential> list) {
        if ( list == null ) {
            return null;
        }

        List<CredentialDto> list1 = new ArrayList<CredentialDto>( list.size() );
        for ( Credential credential : list ) {
            list1.add( entityToDto( credential ) );
        }

        return list1;
    }

    @Override
    public List<Credential> toListEntity(List<CredentialDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Credential> list1 = new ArrayList<Credential>( list.size() );
        for ( CredentialDto credentialDto : list ) {
            list1.add( dtoToEntity( credentialDto ) );
        }

        return list1;
    }
}
