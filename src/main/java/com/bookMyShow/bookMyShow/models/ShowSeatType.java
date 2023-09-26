package com.bookMyShow.bookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private SeatType seatType;

    private double price;
}
