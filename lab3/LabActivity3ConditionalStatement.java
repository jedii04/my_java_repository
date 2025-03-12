// Gerard Dustin M. Beltran BSCS-1A
import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // This is the user input
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        // This is where the age validation, ensure the employee is within the allowed working age
        if (age < 18) {
            System.out.println("Minors are not allowed");
            return;
        } else if (age >= 65) {
            System.out.println("Senior Citizens are not allowed");
            return;
        }
        
        System.out.print("Enter hours worked: ");
        double hoursWorked = scanner.nextDouble();
        
        // Ensure a valid number of hours is entered
        if (hoursWorked > 24) {
            System.out.println("Number of hours worked cannot exceed 24 hours");
            return;
        } else if (hoursWorked <= 0) {
            System.out.println("Wrong input on daily work hours");
            return;
        }
        
        System.out.print("Enter hourly wage: ");
        double hourlyWage = scanner.nextDouble();
        
        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int roleCode = scanner.nextInt();
        
        // Assign job role based on inputted role code
        String role;
        switch (roleCode) {
            case 1:
                role = "Manager";
                break;
            case 2:
                role = "Supervisor";
                break;
            case 3:
                role = "Staff";
                break;
            case 4:
                role = "Intern";
                break;
            default:
                role = "Undefined";
        }
        
        // The salary calculations, it compute salary based on hours worked and hourly wage
        double dailySalary = hoursWorked * hourlyWage;
        double weeklySalary = dailySalary * 5;
        double monthlySalary = weeklySalary * 4;
        double grossYearlySalary = monthlySalary * 12;
        double netYearlySalary = grossYearlySalary;
        
       // Tax and government-mandated deduction
        if (grossYearlySalary > 250000) {
            netYearlySalary -= (grossYearlySalary * 0.32) + 1500; // Apply tax and benefits deduction
        } else {
            netYearlySalary -= 1500; // Only deduct government-mandated benefits
        }
        
        int yearsToRetirement = 65 - age; // Calculate remaining years until retirement
        
        // The output display the computed employee information
        System.out.println("\nEmployee Information");
        System.out.println("-----------------------------");
        System.out.printf("%-25s %s, %s\n", "Full Name:", lastName.toUpperCase(), firstName.toUpperCase());
        System.out.printf("%-25s %d years old\n", "Age:", age);
        System.out.printf("%-25s %s\n", "Position:", role);
        System.out.printf("%-25s %d years\n", "Years to Retirement:", yearsToRetirement);
        System.out.printf("%-25s Php %.2f\n", "Daily Salary:", dailySalary);
        System.out.printf("%-25s Php %.2f\n", "Weekly Salary:", weeklySalary);
        System.out.printf("%-25s Php %.2f\n", "Monthly Salary:", monthlySalary);
        System.out.printf("%-25s Php %.2f\n", "Gross Yearly Salary:", grossYearlySalary);
        System.out.printf("%-25s Php %.2f\n", "Net Yearly Salary:", netYearlySalary);
        
        scanner.close();
    }
}