package com.bookMyShow.bookMyShow.DTO;

import com.bookMyShow.bookMyShow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class bookTicketResponseDTO {
    private Ticket ticket;

    private ResponseStatus responseStatus;
}
