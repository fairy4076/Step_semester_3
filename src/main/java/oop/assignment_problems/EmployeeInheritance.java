package oop.assignment_problems;

class Employee {
    private int empId;
    private String empName;
    private double salary;

    Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }
}

class ManagerEmployee extends Employee {
    private double teamBonus;

    ManagerEmployee(int empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}

class InternEmployee extends Employee {
    private double stipendCap;

    InternEmployee(int empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }
}

public class EmployeeInheritance {
    public static void main(String[] args) {

        Employee employee = new Employee(101, "Aman", 40000);
        ManagerEmployee manager = new ManagerEmployee(102, "Riya", 70000, 8000);
        InternEmployee intern = new InternEmployee(103, "Sam", 12000, 10000);

        Employee[] employees = {employee, manager, intern};

        for (Employee emp : employees) {

            if (emp instanceof ManagerEmployee) {
                ManagerEmployee managerEmployee = (ManagerEmployee) emp;
                System.out.println("Manager effective pay: Rs " +
                        managerEmployee.effectiveSalary());

            } else if (emp instanceof InternEmployee) {
                InternEmployee internEmployee = (InternEmployee) emp;
                System.out.println("Intern effective pay: Rs " +
                        internEmployee.effectiveSalary());

            } else {
                System.out.println("Plain employee pay: Rs " +
                        emp.getSalary());
            }
        }
    }
}
