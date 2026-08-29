package oop.class_problems.week4;

public class FareSplitter {
    private String tripId;
    private double totalFare;
    private int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (totalFare < 0) {
            throw new IllegalArgumentException("Fare cannot be negative");
        }

        if (passengerCount <= 0) {
            throw new IllegalArgumentException("Passenger count must be positive");
        }

        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0.0, 2);
    }

    public double[] fareBreakdown() {
        double[] shares = new double[passengerCount];

        double share = Math.floor((totalFare / passengerCount) * 100) / 100;
        double distributed = 0;

        for (int i = 0; i < passengerCount - 1; i++) {
            shares[i] = share;
            distributed += share;
        }

        shares[passengerCount - 1] =
                Math.round((totalFare - distributed) * 100) / 100.0;

        return shares;
    }

    public boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }

    public static void main(String[] args) {

        FareSplitter trip1 =
                new FareSplitter("TRIP001", 100000, 3);

        double[] breakdown1 = trip1.fareBreakdown();

        for (double amount : breakdown1) {
            System.out.printf("%.2f ", amount);
        }

        System.out.println();

        FareSplitter trip2 =
                new FareSplitter("TRIP003");

        double[] breakdown2 = trip2.fareBreakdown();

        for (double amount : breakdown2) {
            System.out.printf("%.2f ", amount);
        }

        System.out.println();

        System.out.println(
                "Overdue: " + trip1.isConfirmationOverdue(2, 3)
        );
    }
}