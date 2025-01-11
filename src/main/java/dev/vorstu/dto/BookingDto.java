package dev.vorstu.dto;

import dev.vorstu.entity.Parking;
import dev.vorstu.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Long id;
    private Long parkingId;
    private Date timeBookStart;
    private Date timeBookEnd;
    private Boolean isApproved;
    private Long userId;
}
