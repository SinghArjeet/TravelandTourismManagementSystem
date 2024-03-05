package com.TravelandTourismManagementSystem;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackID;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comments")
    private String comments;

    // Constructors, getters, and setters

    public Feedback() {
        // Default constructor required by Hibernate
    }

    public Feedback(Customer customer, int rating, String comments) {
        this.customer = customer;
        this.rating = rating;
        this.comments = comments;
    }

    // Getters and Setters

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    // Other getters and setters
}