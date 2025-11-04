package com.project.HotelBooking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room_amenities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(RoomAmenityId.class)
public class RoomAmenity {

    @Id
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Id
    @ManyToOne
    @JoinColumn(name = "amenity_id")
    private Amenity amenity;
}