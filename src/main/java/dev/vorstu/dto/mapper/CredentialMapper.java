package dev.vorstu.dto.mapper;

import dev.vorstu.dto.CredentialDto;
import dev.vorstu.entity.Credential;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CredentialMapper {

    Credential dtoToEntity(CredentialDto dto);

    CredentialDto entityToDto(Credential entity);

    List<CredentialDto> toList(List<Credential> list);

    List<Credential> toListEntity(List<CredentialDto> list);
}
