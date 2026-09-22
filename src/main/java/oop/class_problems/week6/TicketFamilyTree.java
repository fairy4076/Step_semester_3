package oop.class_problems.week6;

class PremiumWorkshopTicket extends WorkshopTicket {

    private double kitFee;

    public PremiumWorkshopTicket(String attendeeId, double basePrice,
                                 String track, double kitFee) {
        super(attendeeId, basePrice, track);
        this.kitFee = kitFee;
    }

    @Override
    public void printTicket() {
        System.out.println(
            "Premium Workshop Ticket | Track: "
            + track + " | Kit Fee: " + kitFee
            + " | Balance Due: " + getBalanceDue()
        );
    }
}

class HackathonTicket extends EventTicket {

    private String teamName;

    public HackathonTicket(String attendeeId, double basePrice,
                           String teamName) {
        super(attendeeId, basePrice);
        this.teamName = teamName;
    }

    @Override
    public void printTicket() {
        System.out.println(
            "Hackathon Ticket | Team: "
            + teamName + " | Balance Due: "
            + getBalanceDue()
        );
    }
}

public class TicketFamilyTree {

    public static String classifyGeneration(EventTicket ticket) {

        if (ticket instanceof PremiumWorkshopTicket) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (ticket instanceof HackathonTicket) {
            return "Hierarchical sibling (independent branch)";
        }

        return "Standard Event Ticket";
    }

    public static double getTotalBalanceDue(EventTicket[] tickets) {

        double total = 0;

        for (EventTicket ticket : tickets) {
            total += ticket.getBalanceDue();
        }

        return total;
    }

    public static void main(String[] args) {

        EventTicket standard =
                new EventTicket("STU1", 500);

        WorkshopTicket workshop =
                new WorkshopTicket("STU2", 1200, "AI/ML");

        PremiumWorkshopTicket premium =
                new PremiumWorkshopTicket(
                    "STU3", 2000, "Cloud Native", 300
                );

        HackathonTicket hackathon =
                new HackathonTicket(
                    "STU4", 800, "Byte Force"
                );

        standard.printTicket();
        workshop.printTicket();
        premium.printTicket();
        hackathon.printTicket();

        System.out.println(
            classifyGeneration(premium)
        );

        System.out.println(
            classifyGeneration(hackathon)
        );

        EventTicket[] tickets = {
            standard,
            workshop,
            premium,
            hackathon
        };

        System.out.println(
            getTotalBalanceDue(tickets)
        );
    }
}