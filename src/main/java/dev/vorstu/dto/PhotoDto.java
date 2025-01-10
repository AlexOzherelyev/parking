package dev.vorstu.dto;

import dev.vorstu.entity.Parking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {

    private Long id;
    private String image;
    private Parking parking;
}
