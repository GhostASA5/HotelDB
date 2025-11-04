package com.project.HotelBooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "room_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {

    @Id
    private Long typeId;

    @Convert(converter = RoomTypeNameConverter.class)
    private RoomTypeName typeName;

    private BigDecimal price;

    private Integer maxGuests;

    private String description;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Room> rooms;
}
