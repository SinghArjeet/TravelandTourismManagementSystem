package com.TravelandTourismManagementSystem;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MenuDrivenHibernateMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Add a Customer");
            System.out.println("2. Update a Customer");
            System.out.println("3. Delete a Customer");
            System.out.println("4. Add a Booking");
            System.out.println("5. Update a Booking");
            System.out.println("6. Delete a Booking");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    updateCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    addBooking();
                    break;
                case 5:
                    updateBooking1();
                    break;
                case 6:
                    deleteBooking();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
            }
        }

        scanner.close();
    }

    private static void addCustomer() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Prompt user for customer details
            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Contact Information: ");
            String contactInformation = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            System.out.print("Enter Nationality: ");
            String nationality = scanner.nextLine();

            // Create a new Customer instance
            Customer customer = new Customer(name, contactInformation, email, address, nationality);

            // Save the customer to the database
            session.save(customer);

            transaction.commit();
            System.out.println("Customer added successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    private static void updateCustomer() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Prompt user for customer ID to update
            System.out.print("Enter Customer ID to update: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Retrieve the customer from the database
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                // Prompt user for updated details
                System.out.print("Enter Updated Name: ");
                String updatedName = scanner.nextLine();
                System.out.print("Enter Updated Contact Information: ");
                String updatedContactInformation = scanner.nextLine();
                System.out.print("Enter Updated Email: ");
                String updatedEmail = scanner.nextLine();
                System.out.print("Enter Updated Address: ");
                String updatedAddress = scanner.nextLine();
                System.out.print("Enter Updated Nationality: ");
                String updatedNationality = scanner.nextLine();

                // Update the customer details
                customer.setName(updatedName);
                customer.setContactInformation(updatedContactInformation);
                customer.setEmail(updatedEmail);
                customer.setAddress(updatedAddress);
                customer.setNationality(updatedNationality);

                // Save the updated customer to the database
                session.update(customer);

                transaction.commit();
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Customer with ID " + customerId + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    private static void deleteCustomer() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Prompt user for customer ID to delete
            System.out.print("Enter Customer ID to delete: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Retrieve the customer from the database
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                // Delete the customer from the database
                session.delete(customer);

                transaction.commit();
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer with ID " + customerId + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    private static void addBooking() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Prompt user for booking details
            System.out.print("Enter Customer ID for the Booking (foreign key): ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Retrieve the customer from the database
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                System.out.print("Enter Travel Date (YYYY-MM-DD): ");
                String travelDateStr = scanner.nextLine();
                LocalDate travelDate = LocalDate.parse(travelDateStr);

                System.out.print("Enter Return Date (YYYY-MM-DD): ");
                String returnDateStr = scanner.nextLine();
                LocalDate returnDate = LocalDate.parse(returnDateStr);

                System.out.print("Enter Total Cost: ");
                double totalCost = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Payment Status: ");
                String paymentStatus = scanner.nextLine();

                System.out.print("Enter Booking Status: ");
                String bookingStatus = scanner.nextLine();

                // Create a new Booking instance
                Booking booking = new Booking(customer, travelDate, returnDate, totalCost, paymentStatus, bookingStatus);

                // Save the booking to the database
                session.save(booking);

                transaction.commit();
                System.out.println("Booking added successfully.");
            } else {
                System.out.println("Customer with ID " + customerId + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    private static void updateBooking1() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Prompt user for booking ID to update
            System.out.print("Enter Booking ID to update: ");
            int bookingId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Retrieve the booking from the database
            Booking booking = session.get(Booking.class, bookingId);

            if (booking != null) {
                // Prompt user for updated details
                System.out.print("Enter Updated Travel Date (YYYY-MM-DD): ");
                String updatedTravelDateStr = scanner.nextLine();
                LocalDate updatedTravelDate = LocalDate.parse(updatedTravelDateStr);

                System.out.print("Enter Updated Return Date (YYYY-MM-DD): ");
                String updatedReturnDateStr = scanner.nextLine();
                LocalDate updatedReturnDate = LocalDate.parse(updatedReturnDateStr);

                System.out.print("Enter Updated Total Cost: ");
                double updatedTotalCost = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Updated Payment Status: ");
                String updatedPaymentStatus = scanner.nextLine();

                System.out.print("Enter Updated Booking Status: ");
                String updatedBookingStatus = scanner.nextLine();

                // Update the booking details
                booking.setTravelDate(updatedTravelDate);
                booking.setReturnDate(updatedReturnDate);
                booking.setTotalCost(updatedTotalCost);
                booking.setPaymentStatus(updatedPaymentStatus);
                booking.setBookingStatus(updatedBookingStatus);

                // Save the updated booking to the database
                session.update(booking);

                transaction.commit();
                System.out.println("Booking updated successfully.");
            } else {
                System.out.println("Booking with ID " + bookingId + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    private static void updateBooking() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Prompt user for booking ID to update
            System.out.print("Enter Booking ID to update: ");
            int bookingId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Retrieve the booking from the database
            Booking booking = session.get(Booking.class, bookingId);

            if (booking != null) {
                // Prompt user for updated details
                System.out.print("Enter Updated Travel Date (YYYY-MM-DD): ");
                String updatedTravelDateStr = scanner.nextLine();
                LocalDate updatedTravelDate = LocalDate.parse(updatedTravelDateStr);

                System.out.print("Enter Updated Return Date (YYYY-MM-DD): ");
                String updatedReturnDateStr = scanner.nextLine();
                LocalDate updatedReturnDate = LocalDate.parse(updatedReturnDateStr);

                System.out.print("Enter Updated Total Cost: ");
                double updatedTotalCost = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Updated Payment Status: ");
                String updatedPaymentStatus = scanner.nextLine();

                System.out.print("Enter Updated Booking Status: ");
                String updatedBookingStatus = scanner.nextLine();

                // Update the booking details
                booking.setTravelDate(updatedTravelDate);
                booking.setReturnDate(updatedReturnDate);
                booking.setTotalCost(updatedTotalCost);
                booking.setPaymentStatus(updatedPaymentStatus);
                booking.setBookingStatus(updatedBookingStatus);

                // Save the updated booking to the database
                session.update(booking);

                transaction.commit();
                System.out.println("Booking updated successfully.");
            } else {
                System.out.println("Booking with ID " + bookingId + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void deleteBooking() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Prompt user for booking ID to delete
            System.out.print("Enter Booking ID to delete: ");
            int bookingId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Retrieve the booking from the database
            Booking booking = session.get(Booking.class, bookingId);

            if (booking != null) {
                // Delete the booking from the database
                session.delete(booking);

                transaction.commit();
                System.out.println("Booking deleted successfully.");
            } else {
                System.out.println("Booking with ID " + bookingId + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
       }
    }
}