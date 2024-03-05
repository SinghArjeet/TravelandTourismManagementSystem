package com.TravelandTourismManagementSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int hotelID;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_information")
    private String contactInformation;

    @Column(name = "rating")
    private int rating;

    @Column(name = "facilities")
    private String facilities;

    @Column(name = "room_types")
    private String roomTypes;

    @Column(name = "price_per_night")
    private double pricePerNight;

    // Constructors, getters, and setters

    public Hotel() {
        // Default constructor required by Hibernate
    }

    public Hotel(String name, String address, String contactInformation, int rating, String facilities, String roomTypes, double pricePerNight) {
        this.name = name;
        this.address = address;
        this.contactInformation = contactInformation;
        this.rating = rating;
        this.facilities = facilities;
        this.roomTypes = roomTypes;
        this.pricePerNight = pricePerNight;
    }

    // Getters and Setters

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    // Other getters and setters
}