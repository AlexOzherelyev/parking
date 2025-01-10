package dev.vorstu.service;


import dev.vorstu.dto.MessageDto;
import dev.vorstu.dto.mapper.MessageMapper;
import dev.vorstu.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper mapper;

    public MessageDto create(MessageDto messageDto) {
        return mapper.entityToDto(
                messageRepository.save(mapper.dtoToEntity(messageDto))
        );
    }

    public MessageDto update(MessageDto messageDto) {
        return mapper.entityToDto(
                messageRepository.save(mapper.dtoToEntity(messageDto))
        );
    }

    public Long delete(Long id) {
        messageRepository.deleteById(id);
        return id;
    }

    public List<MessageDto> findAll() {
        return mapper.toList(
                messageRepository.findAll());
    }

}
