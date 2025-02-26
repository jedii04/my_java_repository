import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
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

        // This will put the full name
        String fullName = firstName + " " + lastName;

        // To compute the daily wage
        double dailyWage = hoursWorked * hourlyWage;

        // This will display the results
        System.out.println("\nEmployee Information:");
        System.out.println("----------------------"); // Added line separator
        System.out.printf("%-15s : %s%n", "Full Name", fullName);
        System.out.printf("%-15s : %d years old%n", "Age", age);
        System.out.printf("%-15s : PHP %.2f%n", "Daily Salary", dailyWage);

        // Close scanner
        scanner.close();
    }
}