package dev.vorstu.dto;

import com.fasterxml.jackson.annotation.*;
import dev.vorstu.entity.ChatRoom;
import dev.vorstu.entity.Parking;
import dev.vorstu.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {

    private Long id;
    private Boolean isApproved;
    private Long userId;
    private List<ParkingDto> parking;
    private List<ChatRoom> chatRoom;

}
