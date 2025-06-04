Lab 1 
The program titled "LabActivity1EmployeeInformationSystem" is a simple Java console application designed to collect and display basic employee information.

### Purpose:

To gather user input, compute a value (daily wage), and display formatted employee information. It demonstrates the use of:

* Input/output operations
* Basic arithmetic
* String manipulation
* Formatted printing

What the program does:

1. Prompts the user to input:

   * First name
   * Last name
   * Age
   * Hours worked
   * Hourly wage

2. Combines the first and last names into a full name.

3. Calculates the **daily salary** using the formula:

   ```
   dailyWage = hoursWorked * hourlyWage
   ```

4. Displays the collected and computed information in a clean, formatted way.

---
Example Output:

If the user enters:

```
First Name: John
Last Name: Doe
Age: 28
Hours Worked: 8
Hourly Wage: 100
```

The output will be:

```
Employee Information:
----------------------
Full Name       : John Doe
Age             : 28 years old
Daily Salary    : PHP 800.00
```

Educational Use:

This program is most likely a beginner-level lab activity for learning how to use:

* The `Scanner` class for input
* Variables and data types
* Simple calculations and output formatting in Java
---
Lab 2 
The LabActivity2EmployeeInformationSystemPart2 program is an enhanced version of the previous employee information system. In addition to gathering basic employee details such as first name, last name, age, hours worked, and hourly wage, this program performs more complex calculations, including determining the employee’s years to retirement, daily salary, weekly salary, monthly salary, gross yearly salary, and net yearly salary after tax deductions and fixed expenses.

The program first collects the user’s input, including the first name, last name, age, hours worked, and hourly wage. It then calculates several additional values:

* The full name is formatted with the last name first and the first name second, in uppercase.
* The years to retirement are calculated based on a retirement age of 65.
* The daily salary is computed by multiplying the hours worked by the hourly wage.
* The weekly salary is calculated by assuming the employee works 5 days a week.
* The monthly salary is derived by multiplying the weekly salary by 4 (assuming 4 weeks in a month).
* The gross yearly salary is computed by multiplying the monthly salary by 12.
* The net yearly salary is calculated by subtracting 32% tax and a fixed expense of 1500 from the gross yearly salary.

Finally, the program outputs all of this information in a neat, formatted manner. It also shows the employee’s years to retirement, and the salaries (daily, weekly, monthly, and yearly) both gross and net.

Example Output:

For an employee with the following details:

* First Name: John
* Last Name: Doe
* Age: 30
* Hours Worked: 8
* Hourly Wage: 100 PHP

The output might look like this:

```
Employee Information
----------------------
Full Name           : DOE, JOHN
Age                 : 30 years old
Years to Retirement : 35 years
Daily Salary       : Php 800.00
Weekly Salary      : Php 4000.00
Monthly Salary     : Php 16000.00
Gross Yearly Salary: Php 192000.00
Net Yearly Salary  : Php 128640.00
```

Educational Value:

This program enhances the basic understanding of Java programming by introducing more advanced concepts like:

* Calculating and manipulating **multiple salary types**
* Applying **mathematical operations** to compute future financial outcomes
* Formatting the output neatly using `printf`
* Handling **financial deductions** (taxes, expenses)
---
Lab 3 
The Lab Activity 3 Conditional Statement program is designed to gather employee details, validate inputs, and compute their salary based on various factors such as their age, working hours, and job role. Here’s how the program works step by step:

1. User Input:

   * The program starts by asking the user for their personal details: first name, last name, age, hours worked, hourly wage, and job role.
   * These inputs are used to compute salary details and validate whether the input values make sense (e.g., valid age, valid working hours).

2. Age Validation:

   * The program checks if the employee is of working age. Employees under 18 are considered minors and are not allowed, while employees over 65 are considered senior citizens and are also excluded.
   * If the age does not meet the criteria (18 to 65), an appropriate message is shown and the program terminates early.

3. Hours Worked Validation:

   * The program ensures that the hours worked are within a valid range. It prevents inputs that exceed 24 hours a day or less than 1 hour (which would be an invalid entry). If the hours fall outside this range, an error message is displayed and the program ends.

4. Job Role Assignment:

   * The program asks for a job role code, where the user inputs a number (1 for Manager, 2 for Supervisor, 3 for Staff, and 4 for Intern).
   * A switch statement is used to assign a specific job role based on the entered code. If an invalid role code is entered (a number other than 1, 2, 3, or 4), the role is set as "Undefined".

5. Salary Calculations:

   * The program calculates the daily salary by multiplying the number of hours worked by the hourly wage.
   * It then calculates the weekly salary by assuming the employee works 5 days a week (daily salary \* 5).
   * The monthly salary is calculated by multiplying the weekly salary by 4 (assuming 4 weeks in a month).
   * The gross yearly salary is calculated by multiplying the monthly salary by 12 (for each month of the year).

6. Tax and Deduction Calculations:

   * If the employee's gross yearly salary exceeds PHP 250,000, a tax of 32% and a fixed deduction of PHP 1500 are applied to calculate the net yearly salary.
   * If the gross yearly salary is less than PHP 250,000, only the PHP 1500 deduction is applied (no tax).

7. Years to Retirement:

   * The program calculates how many years are left until the employee reaches the standard retirement age of 65 by subtracting the current age from 65.

8. Display Output:

   * Finally, the program prints all the collected and computed information in a formatted way:

     * Full name (last name, first name)
     * Age
     * Position (job role)
     * Years to retirement
     * Daily, weekly, monthly, gross yearly, and net yearly salaries

Purpose of the Program:
This program is primarily used to:

* Learn how to gather user input and validate it.
* Understand how to apply conditional logic to check for valid inputs.
* Perform basic salary calculations and apply deductions based on conditions.
* Display formatted output for user-friendly presentation.

MidtermLabExam
The IT Ticket System program is a command-line application designed to manage IT support tickets. The program offers a simple way to add tickets, update their status, view all tickets, and generate reports.

The program has a menu with five options:

1. Add Ticket: This allows the user to create a new support ticket by entering an issue description and selecting an urgency level (Low, Medium, or High). The ticket is then added to the system with a default status of "Pending."

2. Update Ticket Status: This option allows the user to update the status of an existing ticket to either "In Progress" or "Resolved." The program ensures that a ticket cannot be updated if it is already resolved.

3. Show All Tickets: This option displays all tickets with their urgency levels, issue descriptions, and current statuses (Pending, In Progress, or Resolved).

4. Generate Report: The program generates a report showing the total number of tickets, how many are pending or in progress, and how many are resolved.

5. Exit: This option exits the program, ending the ticket management session.

The program stores tickets in arrays with a maximum capacity of 5 tickets. It validates inputs such as urgency level and ticket number to ensure users provide correct data. It also prevents the addition of new tickets once the maximum limit is reached.

In summary, this program simulates a basic IT ticket management system, teaching fundamental concepts such as array manipulation, input validation, conditional logic, and menu-driven program design. It is a useful practice for beginners learning Java programming.
---
Lab 4 
This program creates a graphical user interface (GUI) application using Java's AWT library to collect employee information, perform calculations, and display results. Here is an explanation of what the program does:

Key Components:

1. Labels and TextFields are used to collect input from the user. There are labels for "First Name", "Last Name", "Age", "Hours Worked", and "Hourly Rate", each paired with a corresponding TextField to input data.

2. A Button is provided for the user to submit their inputs. When the button is clicked, the actionPerformed method is triggered.

3. A TextArea is used to display the results of the calculation (i.e., the employee’s full name, age, and daily wage). It is set to be read-only to prevent the user from editing the output.

4. Panels are used to organize the layout of the GUI. For example:

   * formPanel holds the labels and text fields for user inputs.
   * buttonPanel holds the "Submit" button.
   * outputPanel holds the label and text area for displaying results.

5. A Window Listener is included for the window's close button. When the user clicks the close button (X), the window will close gracefully.

Workflow:

1. The user enters their first name, last name, age, hours worked, and hourly rate in the text fields.

2. When the user clicks the "Submit" button, the program checks:

   * If any of the fields are empty. If any field is empty, an error message is shown.
   * It then checks if the age is a valid positive integer and if the hours worked and hourly rate are valid non-negative numbers.

3. Once all inputs are validated, the program calculates the daily wage as the product of hours worked and the hourly rate.

4. The full name, age, and daily wage are displayed in the text area.

Example Output:

If the user inputs the following:

* First Name: John
* Last Name: Doe
* Age: 30
* Hours Worked: 8
* Hourly Rate: 150

The output would be:

```
Full Name: John Doe
Age: 30 years old
Daily Salary: PHP 1200.00
```

Features:

* Input Validation ensures that all fields are filled in and that the age, hours worked, and hourly rate are valid numbers.
* The Calculation computes the daily wage based on hours worked and hourly rate.
* The GUI uses a graphical interface for user interaction, making it more user-friendly compared to a command-line program.

Closing the Program:

When the user closes the window, the program disposes of the frame and exits properly.

This program is a simple but effective way of managing employee information and performing basic calculations through a graphical interface using Java AWT.
---
Lab 5
This Java program is a simple quiz application built using AWT (Abstract Window Toolkit) for GUI.

What the program does:

* It presents multiple-choice questions (3 questions total) to the user.
* Each question has 4 options (A, B, C, D).
* The user selects one option per question using checkboxes.
* When the user clicks the Next button:

  * The program checks if an option was selected.
  * It verifies if the selected answer is correct and updates the score.
  * It then loads the next question.
  * After the last question, it displays the final score and disables further input.

Key Features:

* Shows one question at a time.
* Only one option can be selected at a time (using `CheckboxGroup`).
* Provides feedback if no answer is selected before pressing Next.
* Displays the total score at the end of the quiz.
* The window is styled with a dark blue top border and uses fonts/colors for better readability.
* The quiz is non-resizable and centered on the screen.

---

Summary:

This program is an interactive quiz app where users answer questions about data structures, CPU roles, and protocols, and then receive their score.
---
Lab 6

This Java program is a To-Do List application built using Swing for the graphical user interface.

What the program is about:

* It allows users to manage a list of tasks.
* The main window displays a table listing tasks, each with:

  * Task Name
  * Task Description
  * Status (Not Started, Ongoing, Completed)
* There is an **"Add Task"** button that opens a separate form window.
* In the form window, the user can:

  * Enter the task name
  * Enter a description
  * Select the status from a dropdown menu
* When the user clicks Save Task, the new task is added to the main table.
* The tasks displayed in the table cannot be edited directly.
* The program uses two windows:

  * The main window with the task list.
  * A popup form window to add new tasks.

Summary:

This program is a simple desktop To-Do List app where users can add tasks with descriptions and statuses, and view the list of tasks in a table format.
---
