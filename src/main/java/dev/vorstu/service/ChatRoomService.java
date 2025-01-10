package dev.vorstu.service;

import dev.vorstu.dto.ChatRoomDto;
import dev.vorstu.dto.mapper.ChatRoomMapper;
import dev.vorstu.repositories.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMapper mapper;

    public ChatRoomDto create(ChatRoomDto chatRoomDto) {
        return mapper.entityToDto(
                chatRoomRepository.save(mapper.dtoToEntity(chatRoomDto))
        );
    }

    public ChatRoomDto update(ChatRoomDto chatRoomDto) {
        return mapper.entityToDto(
                chatRoomRepository.save(mapper.dtoToEntity(chatRoomDto))
        );
    }

    public Long delete(Long id) {
        chatRoomRepository.deleteById(id);
        return id;
    }

    public List<ChatRoomDto> findAll() {
        return mapper.toList(
                chatRoomRepository.findAll());
    }
}
