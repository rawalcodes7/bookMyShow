package com.bookMyShow.bookMyShow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends  BaseModel{

    @ManyToOne
    private User bookedBy;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<ShowSeat> showSeatList;

    private double totalAmount;

    @Enumerated(EnumType.ORDINAL)
//    @ElementCollection --> this can be removed since we don't have a list ticketStatus.l
    private TicketStatus ticketStatus;

    private Date timeOfBooking;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;
}
