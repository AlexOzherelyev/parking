package dev.vorstu.dto.mapper;

import dev.vorstu.dto.ChatRoomDto;
import dev.vorstu.entity.ChatRoom;
import dev.vorstu.entity.Message;
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
public class ChatRoomMapperImpl implements ChatRoomMapper {

    @Override
    public ChatRoom dtoToEntity(ChatRoomDto dto) {
        if ( dto == null ) {
            return null;
        }

        ChatRoom chatRoom = new ChatRoom();

        chatRoom.setId( dto.getId() );
        chatRoom.setUser( dto.getUser() );
        chatRoom.setOwner( dto.getOwner() );
        List<Message> list = dto.getMessage();
        if ( list != null ) {
            chatRoom.setMessage( new ArrayList<Message>( list ) );
        }

        return chatRoom;
    }

    @Override
    public ChatRoomDto entityToDto(ChatRoom entity) {
        if ( entity == null ) {
            return null;
        }

        ChatRoomDto chatRoomDto = new ChatRoomDto();

        chatRoomDto.setId( entity.getId() );
        chatRoomDto.setUser( entity.getUser() );
        chatRoomDto.setOwner( entity.getOwner() );
        List<Message> list = entity.getMessage();
        if ( list != null ) {
            chatRoomDto.setMessage( new ArrayList<Message>( list ) );
        }

        return chatRoomDto;
    }

    @Override
    public List<ChatRoomDto> toList(List<ChatRoom> list) {
        if ( list == null ) {
            return null;
        }

        List<ChatRoomDto> list1 = new ArrayList<ChatRoomDto>( list.size() );
        for ( ChatRoom chatRoom : list ) {
            list1.add( entityToDto( chatRoom ) );
        }

        return list1;
    }

    @Override
    public List<ChatRoom> toListEntity(List<ChatRoomDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ChatRoom> list1 = new ArrayList<ChatRoom>( list.size() );
        for ( ChatRoomDto chatRoomDto : list ) {
            list1.add( dtoToEntity( chatRoomDto ) );
        }

        return list1;
    }
}
