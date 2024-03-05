package com.TravelandTourismManagementSystem;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentID;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    // Constructors, getters, and setters

    public Payment() {
        // Default constructor required by Hibernate
    }

    public Payment(Booking booking, Date paymentDate, double paymentAmount, String paymentMethod) {
        this.booking = booking;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    // Other getters and setters
}