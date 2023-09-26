package com.bookMyShow.bookMyShow.models;

import jakarta.persistence.*;

import java.util.Date;

public class Payment extends BaseModel {
    private PaymentMethod paymentMethod;

    private Date timeOfPayment;

    private double amount;

    private String referenceId;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Ticket ticket;
}
