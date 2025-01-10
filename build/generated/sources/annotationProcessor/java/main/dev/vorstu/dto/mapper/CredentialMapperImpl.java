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
    date = "2025-01-10T19:13:28+0300",
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

        Credential credential = new Credential();

        credential.setId( dto.getId() );
        credential.setUsername( dto.getUsername() );
        credential.setPassword( dto.getPassword() );
        credential.setRole( dto.getRole() );
        credential.setUser( userMapper.dtoToEntity( dto.getUser() ) );

        return credential;
    }

    @Override
    public CredentialDto entityToDto(Credential entity) {
        if ( entity == null ) {
            return null;
        }

        CredentialDto credentialDto = new CredentialDto();

        credentialDto.setId( entity.getId() );
        credentialDto.setUsername( entity.getUsername() );
        credentialDto.setPassword( entity.getPassword() );
        credentialDto.setRole( entity.getRole() );
        credentialDto.setUser( userMapper.entityToDto( entity.getUser() ) );

        return credentialDto;
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
