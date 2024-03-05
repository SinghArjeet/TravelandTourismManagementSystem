package com.TravelandTourismManagementSystem;

import javax.persistence.*;

@Entity
@Table(name = "tour_guides")
public class TourGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guide_id")
    private int guideID;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_information")
    private String contactInformation;

    @Column(name = "language")
    private String language;

    @Column(name = "specialization")
    private String specialization;

    // Constructors, getters, and setters

    public TourGuide() {
        // Default constructor required by Hibernate
    }

    public TourGuide(String name, String contactInformation, String language, String specialization) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.language = language;
        this.specialization = specialization;
    }

    // Getters and Setters

    public int getGuideID() {
        return guideID;
    }

    public void setGuideID(int guideID) {
        this.guideID = guideID;
    }

    // Other getters and setters
}