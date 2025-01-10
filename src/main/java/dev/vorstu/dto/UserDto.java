package dev.vorstu.dto;

import dev.vorstu.entity.*;
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
public class UserDto {

    private Long id;
    private String fio;
    private String phone;
    private String email;
    private Long credentialId;
    private OwnerDto owner;
    private List<Booking> booking;
    private List<ChatRoom> chatRoom;


}
