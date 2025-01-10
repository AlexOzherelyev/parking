package dev.vorstu.dto;

import dev.vorstu.entity.ChatRoom;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private Long id;
    private String message;
    private Date messageTime;
    private ChatRoom chatRoom;
}
