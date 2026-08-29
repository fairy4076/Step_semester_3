package oop.class_problems.week4;

import java.util.HashSet;

public class BusTicket {
    private String passengerName;
    private String destination;
    private boolean checkedIn;

    public BusTicket(String passengerName, String destination) {
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid passenger name");
        }

        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid destination");
        }

        if (!passengerName.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Invalid passenger name");
        }

        this.passengerName = passengerName;
        this.destination = destination;
        this.checkedIn = false;
    }

    public void markCheckedIn() {
        if (!checkedIn) {
            checkedIn = true;
            System.out.println(passengerName + " checked in successfully.");
        } else {
            System.out.println(passengerName + " is already checked in.");
        }
    }

    public static void processBatch(String[][] rawBookings) {
        HashSet<String> acceptedBookings = new HashSet<>();

        int valid = 0;
        int rejected = 0;
        int duplicates = 0;

        for (String[] booking : rawBookings) {
            try {
                BusTicket ticket = new BusTicket(booking[0], booking[1]);

                String key = ticket.passengerName.toLowerCase()
                        + "|" + ticket.destination.toLowerCase();

                if (acceptedBookings.contains(key)) {
                    duplicates++;
                } else {
                    acceptedBookings.add(key);
                    valid++;
                }

            } catch (Exception e) {
                rejected++;
            }
        }

        System.out.println("Valid: " + valid
                + " | Rejected: " + rejected
                + " | Duplicates skipped: " + duplicates);
    }

    public static void main(String[] args) {

        String[][] rawBookings = {
            {"Divya", "Chennai"},
            {"", "Bangalore"},
            {"Ravi123", "Pune"},
            {"Divya", "Chennai"},
            {" ", " "}
        };

        processBatch(rawBookings);
    }
}