package dev.vorstu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String address;

    private String code;

    private Long price;

    private Date timeStart;

    private Date timeEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false,updatable = false,insertable = false)
    private Owner owner;

    @Column(name="owner_id")
    private Long ownerId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "parking")
    private Booking booking;

    @OneToMany(mappedBy = "parking",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Photo> photo;

}
