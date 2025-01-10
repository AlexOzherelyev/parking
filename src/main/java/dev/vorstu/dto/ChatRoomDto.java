package dev.vorstu.dto;

import dev.vorstu.entity.Message;
import dev.vorstu.entity.Owner;
import dev.vorstu.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDto {

    private Long id;
    private User user;
    private Owner owner;
    private List<Message> message;
}
