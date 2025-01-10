package dev.vorstu.dto.mapper;

import dev.vorstu.dto.MessageDto;
import dev.vorstu.entity.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-10T19:13:28+0300",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message dtoToEntity(MessageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( dto.getId() );
        message.setMessage( dto.getMessage() );
        message.setMessageTime( dto.getMessageTime() );
        message.setChatRoom( dto.getChatRoom() );

        return message;
    }

    @Override
    public MessageDto entityToDto(Message entity) {
        if ( entity == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setId( entity.getId() );
        messageDto.setMessage( entity.getMessage() );
        messageDto.setMessageTime( entity.getMessageTime() );
        messageDto.setChatRoom( entity.getChatRoom() );

        return messageDto;
    }

    @Override
    public List<MessageDto> toList(List<Message> list) {
        if ( list == null ) {
            return null;
        }

        List<MessageDto> list1 = new ArrayList<MessageDto>( list.size() );
        for ( Message message : list ) {
            list1.add( entityToDto( message ) );
        }

        return list1;
    }

    @Override
    public List<Message> toListEntity(List<MessageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Message> list1 = new ArrayList<Message>( list.size() );
        for ( MessageDto messageDto : list ) {
            list1.add( dtoToEntity( messageDto ) );
        }

        return list1;
    }
}
