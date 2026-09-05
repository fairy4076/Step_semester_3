package oop.class_problems.week5;

public class PatientVitals {

    private double[] readings;
    private int count;

    public PatientVitals(double[] initialReadings) {

        readings = new double[500];
        count = 0;

        for (double reading : initialReadings) {
            recordReading(reading);
        }
    }

    public void recordReading(double reading) {

        if (reading > 0 && reading <= 45) {
            readings[count] = reading;
            count++;
        }
    }

    public double getAverage() {

        if (count == 0) {
            return 0;
        }

        double sum = 0;

        for (int i = 0; i < count; i++) {
            sum += readings[i];
        }

        return sum / count;
    }

    public double[] getAllReadings() {

        double[] copy = new double[count];

        for (int i = 0; i < count; i++) {
            copy[i] = readings[i];
        }

        return copy;
    }

    public static void main(String[] args) {

        PatientVitals v = new PatientVitals(
            new double[]{36.5, -2, 37.1}
        );

        double[] result = v.getAllReadings();

        for (double reading : result) {
            System.out.print(reading + " ");
        }

        System.out.println();

        double[] copy = v.getAllReadings();
        copy[0] = 999;

        System.out.println(v.getAllReadings()[0]);

        System.out.println("Average: " + v.getAverage());
    }
}