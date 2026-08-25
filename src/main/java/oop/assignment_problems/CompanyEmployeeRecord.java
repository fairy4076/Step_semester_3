package oop.assignment_problems;

class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;

    CompanyEmployeeRecord(String name, String empId,
                          Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    String fullProfile() {
        String parking;

        if (slot != null) {
            parking = slot.slotNo;
        } else {
            parking = "no parking assigned";
        }

        double pay;

        if (employee instanceof ManagerEmployee) {
            ManagerEmployee manager = (ManagerEmployee) employee;
            pay = manager.effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            InternEmployee intern = (InternEmployee) employee;
            pay = intern.effectiveSalary();
        } else {
            pay = employee.getSalary();
        }

        return name + " | Pay: Rs " + pay + " | Slot: " + parking;
    }

    public static void main(String[] args) {

        Employee manager = new ManagerEmployee(
                101, "Divya", 70000, 8000);

        Employee employee = new Employee(
                102, "Karan", 40000);

        Employee intern = new InternEmployee(
                103, "Meera", 12000, 10000);

        ParkingSlot slot1 = new ParkingSlot("A1", 4, 0);
        ParkingSlot slot2 = new ParkingSlot("A2", 5, 0);

        CompanyEmployeeRecord record1 =
                new CompanyEmployeeRecord("Divya", "E101",
                        manager, slot1);

        CompanyEmployeeRecord record2 =
                new CompanyEmployeeRecord("Karan", "E102",
                        employee, slot2);

        CompanyEmployeeRecord record3 =
                new CompanyEmployeeRecord("Meera", "E103",
                        intern, null);

        slot1.allot("TN01AA1111");
        slot2.allot("TN01AA2222");

        System.out.println(record1.fullProfile());
        System.out.println(record2.fullProfile());
        System.out.println(record3.fullProfile());

        System.out.println("Total records: " +
                CompanyEmployeeRecord.totalRecords);
    }
}