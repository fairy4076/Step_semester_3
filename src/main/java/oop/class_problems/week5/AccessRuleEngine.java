package oop.class_problems.week5;

public class AccessRuleEngine {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (accessorContext.equals("SAME_CLASS")) {
            return "ALLOWED";
        }

        if (accessorContext.equals("SAME_PACKAGE")) {
            if (fieldModifier.equals("private")) {
                return "DENIED";
            }
            return "ALLOWED";
        }

        if (accessorContext.equals("DIFFERENT_PACKAGE")) {
            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {

            String result = classifyAccess(attempt[0], attempt[1]);

            if (result.equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess("private", "SAME_CLASS")
        );

        System.out.println(
            classifyAccess("default", "DIFFERENT_PACKAGE")
        );

        String[][] attempts = {
            {"protected", "SAME_PACKAGE"},
            {"protected", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeBatch(attempts));

        try {
            PatientRecord p =
                new PatientRecord("MT94", "W3", 98.2, "MediTrack Central");

            System.out.println("PatientRecord created successfully");

        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        try {
            PatientRecord p =
                new PatientRecord("MT9", "W3", 98.2, "MediTrack Central");

            System.out.println("PatientRecord created successfully");

        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
    }
}


class PatientRecord {

    private String patientId;
    String wardCode;
    protected double vitalsScore;
    public String facilityName;

    public PatientRecord(String patientId, String wardCode,
                         double vitalsScore, String facilityName) {

        String id = patientId == null ? "" : patientId.trim();

        if (id.isEmpty() || id.length() < 4) {
            throw new IllegalArgumentException("Invalid patient ID");
        }

        this.patientId = id;
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }
}