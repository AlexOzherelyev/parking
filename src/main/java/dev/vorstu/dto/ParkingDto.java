package dev.vorstu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.vorstu.entity.Booking;
import dev.vorstu.entity.Owner;
import dev.vorstu.entity.Photo;
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
public class ParkingDto {

    private Long id;
    private String address;
    private String code;
    private Long price;
    private Date timeStart;
    private Date timeEnd;
    private Long ownerId;
    private Booking booking;
    private List<Photo> photo;
}
