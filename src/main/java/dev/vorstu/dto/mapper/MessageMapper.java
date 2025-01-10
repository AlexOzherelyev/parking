package dev.vorstu.dto.mapper;


import dev.vorstu.dto.MessageDto;
import dev.vorstu.entity.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message dtoToEntity(MessageDto dto);

    MessageDto entityToDto(Message entity);

    List<MessageDto> toList(List<Message> list);

    List<Message> toListEntity(List<MessageDto> list);
}
