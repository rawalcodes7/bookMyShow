package com.bookMyShow.bookMyShow.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class bookTicketRequestDTO {
    private long userId;

    private long showId;

    private List<Long> seatIds;
}
