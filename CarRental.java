package com.TravelandTourismManagementSystem;

import javax.persistence.*;

@Entity
@Table(name = "car_rentals")
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int rentalID;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "rental_agency")
    private String rentalAgency;

    @Column(name = "pickup_location")
    private String pickupLocation;

    @Column(name = "return_location")
    private String returnLocation;

    @Column(name = "rental_price")
    private double rentalPrice;

    // Constructors, getters, and setters

    public CarRental() {
        // Default constructor required by Hibernate
    }

    public CarRental(String carModel, String rentalAgency, String pickupLocation, String returnLocation, double rentalPrice) {
        this.carModel = carModel;
        this.rentalAgency = rentalAgency;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.rentalPrice = rentalPrice;
    }

    // Getters and Setters

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    // Other getters and setters
}