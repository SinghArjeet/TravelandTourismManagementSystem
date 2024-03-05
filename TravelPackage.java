package com.TravelandTourismManagementSystem;

import javax.persistence.*;

@Entity
@Table(name = "travel_packages")
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private int packageID;

    @Column(name = "destination")
    private String destination;

    @Column(name = "duration")
    private int duration;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "inclusions")
    private String inclusions;

    @Column(name = "exclusions")
    private String exclusions;

    // Constructors, getters, and setters

    public TravelPackage() {
        // Default constructor required by Hibernate
    }

    public TravelPackage(String destination, int duration, String description, double price, String inclusions, String exclusions) {
        this.destination = destination;
        this.duration = duration;
        this.description = description;
        this.price = price;
        this.inclusions = inclusions;
        this.exclusions = exclusions;
    }

    // Getters and Setters

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    // Other getters and setters
}