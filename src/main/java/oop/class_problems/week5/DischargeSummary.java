package oop.class_problems.week5;

public class DischargeSummary {

    private final String patientId;
    private final String[] medicationCodes;

    static {
        System.out.println("Discharge Summary System Initialized");
    }

    public DischargeSummary(String patientId, String[] medicationCodes) {

        if (medicationCodes == null) {
            throw new IllegalArgumentException("Invalid medication codes");
        }

        for (String code : medicationCodes) {
            if (code == null || !code.matches("MED-[A-Z]")) {
                throw new IllegalArgumentException(
                    "Invalid medication code"
                );
            }
        }

        this.patientId = patientId;
        this.medicationCodes = medicationCodes.clone();
    }

    public String[] getMedicationCodes() {
        return medicationCodes.clone();
    }

    public DischargeSummary withCorrectedMedication(
            int index, String newCode) {

        if (index < 0 || index >= medicationCodes.length) {
            throw new IndexOutOfBoundsException();
        }

        if (newCode == null || !newCode.matches("MED-[A-Z]")) {
            throw new IllegalArgumentException(
                "Invalid medication code"
            );
        }

        String[] corrected = medicationCodes.clone();
        corrected[index] = newCode;

        return new DischargeSummary(patientId, corrected);
    }

    public static String processNightlyBatch(
            DischargeSummary[] summaries) {

        int processed = 0;
        int nullSkipped = 0;
        int critical = 0;
        int routine = 0;

        for (DischargeSummary summary : summaries) {

            if (summary == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (summary instanceof CriticalCareDischargeSummary) {
                critical++;
            } else {
                routine++;
            }
        }

        return processed + " processed | "
             + nullSkipped + " null skipped | "
             + critical + " critical-care | "
             + routine + " routine";
    }


    public static void main(String[] args) {

        DischargeSummary d =
            new DischargeSummary(
                "MT2026-0142",
                new String[]{"MED-A", "MED-B"}
            );

        String[] codes = d.getMedicationCodes();
        codes[0] = "TAMPERED";

        System.out.println(d.getMedicationCodes()[0]);

        DischargeSummary corrected =
            d.withCorrectedMedication(0, "MED-C");

        System.out.println(
            corrected.getMedicationCodes()[0]
        );

        DischargeSummary[] batch = {
            new CriticalCareDischargeSummary(
                "MT001",
                new String[]{"MED-X"},
                4
            ),
            null,
            new DischargeSummary(
                "MT002",
                new String[]{"MED-Y"}
            )
        };

        System.out.println(
            processNightlyBatch(batch)
        );
    }
}


class CriticalCareDischargeSummary
        extends DischargeSummary {

    private final int icuDays;

    public CriticalCareDischargeSummary(
            String patientId,
            String[] medicationCodes,
            int icuDays) {

        super(patientId, medicationCodes);
        this.icuDays = icuDays;
    }
}