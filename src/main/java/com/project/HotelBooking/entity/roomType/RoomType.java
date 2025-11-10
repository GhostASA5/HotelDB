package com.project.HotelBooking.entity.roomType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.HotelBooking.entity.Room;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Enumerated(EnumType.STRING)
    @Convert(converter = RoomTypeNameConverter.class)
    private RoomTypeName typeName;

    private BigDecimal price;

    private Integer maxGuests;

    private String description;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Room> rooms;
}
