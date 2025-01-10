package dev.vorstu.dto.mapper;

import dev.vorstu.dto.ChatRoomDto;
import dev.vorstu.entity.ChatRoom;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatRoomMapper {

    ChatRoom dtoToEntity(ChatRoomDto dto);

    ChatRoomDto entityToDto(ChatRoom entity);

    List<ChatRoomDto> toList(List<ChatRoom> list);

    List<ChatRoom> toListEntity(List<ChatRoomDto> list);
}
