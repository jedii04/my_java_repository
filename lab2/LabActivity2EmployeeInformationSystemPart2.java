// Gerard Dustin M. Beltran BSCS-1A
import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // This will be the input
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter hours worked: ");
        double hoursWorked = scanner.nextDouble();

        System.out.print("Enter hourly wage: ");
        double hourlyWage = scanner.nextDouble();

        // This part will show the computation
        String fullName = (lastName + ", " + firstName).toUpperCase();
        int yearsToRetirement = Math.abs(65 - age);
        int dailySalary = (int) Math.round(hoursWorked * hourlyWage);
        int weeklySalary = dailySalary * 5;
        int monthlySalary = weeklySalary * 4;
        int grossYearlySalary = monthlySalary * 12;
        double netYearlySalary = grossYearlySalary - (grossYearlySalary * 0.32) - 1500;

        // This is the output for the coding
        System.out.println("\nEmployee Information");
        System.out.println("----------------------");
        System.out.printf("%-20s: %s\n", "Full Name", fullName);
        System.out.printf("%-20s: %d years old\n", "Age", age);
        System.out.printf("%-20s: %d years\n", "Years to Retirement", yearsToRetirement);
        System.out.printf("%-20s: Php %.2f\n", "Daily Salary", (double) dailySalary);
        System.out.printf("%-20s: Php %.2f\n", "Weekly Salary", (double) weeklySalary);
        System.out.printf("%-20s: Php %.2f\n", "Monthly Salary", (double) monthlySalary);
        System.out.printf("%-20s: Php %.2f\n", "Gross Yearly Salary", (double) grossYearlySalary);
        System.out.printf("%-20s: Php %.2f\n", "Net Yearly Salary", netYearlySalary);
    }
}
