package dev.vorstu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Boolean isApproved;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false,updatable = false,insertable = false)
    private User user;

    @Column(name="user_id")
    private Long userId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    private List<Parking> parking;

    @OneToMany(mappedBy = "owner",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ChatRoom> chatRoom;


}
