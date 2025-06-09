📁 Lab 1 – Employee Information System 

📝 Description:

This Java console application collects and displays basic employee information.

💡 Purpose:

To practice foundational programming skills, including:

* Input/output using `Scanner`
* Basic arithmetic operations
* String manipulation
* Formatted printing using `System.out.printf`

🧮 Program Workflow:

1. Prompts the user for:

   * First Name
   * Last Name
   * Age
   * Hours Worked
   * Hourly Wage
2. Combines the name into a full name.
3. Computes Daily Salary:
   `dailyWage = hoursWorked * hourlyWage`
4. Displays the results in a neat format.

✅ Sample Output:

```
Employee Information:
----------------------
Full Name       : John Doe
Age             : 28 years old
Daily Salary    : PHP 800.00
```

---

📁 Lab 2 – Employee Information System 

📝 Description:

An improved version of Lab 1 that includes more detailed salary computations and formatting enhancements.

🧠 Concepts Introduced:

* Salary breakdown (daily to yearly)
* Tax and fixed deduction
* Age-based retirement calculation
* String formatting with `.toUpperCase()` and name formatting

🧮 Salary Calculations:

* **Daily** = hours × hourly wage
* **Weekly** = daily × 5
* **Monthly** = weekly × 4
* **Gross Yearly** = monthly × 12
* **Net Yearly** = gross – (32% tax + ₱1500 fixed deduction)
* **Years to Retirement** = 65 – current age

✅ Sample Output:

```
Employee Information
----------------------
Full Name           : DOE, JOHN
Age                 : 30 years old
Years to Retirement : 35 years
Daily Salary        : Php 800.00
Weekly Salary       : Php 4000.00
Monthly Salary      : Php 16000.00
Gross Yearly Salary : Php 192000.00
Net Yearly Salary   : Php 128640.00
```

---

📁 Lab 3 – Conditional Statements in Salary System

📝 Description:

Builds upon Lab 2 with added input validation and conditional logic using `if`, `else`, and `switch`.

🔍 Features:

* Age validation:

  * <18: Minor (ineligible)
  * > 65: Senior (ineligible)
* Hours worked validation (must be between 1–24)
* Job role input (via code: 1 = Manager, etc.)
* Salary computation as in Lab 2
* Tax rule:

  * > ₱250,000: 32% tax + ₱1500 deduction
  * ≤ ₱250,000: ₱1500 deduction only

✅ Sample Output Includes:

* Full Name (Last, First)
* Age
* Job Role
* Years to Retirement
* Salaries: Daily, Weekly, Monthly, Yearly (Gross & Net)

---

📁 Lab 4 – Employee Information GUI (AWT)

📝 Description:

This Java AWT-based GUI application mirrors the logic of Lab 1 but with a user-friendly graphical interface.

🧰 GUI Components:

* Labels & TextFields for user input
* Button to trigger calculation
* TextArea to display output
* Panels to organize layout
* WindowListener to handle graceful closing

🛡️ Input Validation:

* Ensures no empty fields
* Validates that:

  * Age is a positive integer
  * Hours worked and hourly rate are non-negative

✅ Output Displayed:

```
Full Name: John Doe
Age: 30 years old
Daily Salary: PHP 1200.00
```

---

📁 Lab 5 – Java Quiz System (AWT)

📝 Description:

A multiple-choice quiz app built with AWT that tests user knowledge interactively.

🧠 Features:

* 3 questions with 4 choices (A–D) each
* **CheckboxGroup** ensures only one answer per question
* Next button checks if an answer is selected and validates it
* Displays final score after last question

🧑‍💻 Interface:

* Non-resizable window
* Styled with a blue top panel and readable font
* Prevents submitting without selecting an option

---

📁 Lab 6 – To-Do List Manager (Swing GUI)

📝 Description:

A simple desktop application using Java Swing for managing tasks with a structured user interface.

🧰 Features:

* Main window displays tasks in a table with:

  * Task Name
  * Task Description
  * Status (Not Started, Ongoing, Completed)
* “Add Task” button opens a new form to add tasks
* Uses dropdown (`JComboBox`) to set task status
* Form inputs are validated before saving
* Tasks cannot be edited directly in the table

---

 📁 MidtermLabExam – IT Ticket Management System

📝 Description:

A console-based IT support ticket system with menu-driven interaction. Demonstrates use of arrays, conditional logic, and reporting.

🧰 Menu Options:

1. Add Ticket (max 5) – includes urgency and issue
2. Update Ticket Status – from Pending → In Progress / Resolved
3. Show All Tickets – display ticket list
4. Generate Report – count and status summary
5. Exit

🧠 Core Concepts:

* Array handling
* Input validation
* Conditional logic
* Menu-loop design using `do-while` or `while`

🔐 Data Validations:

* Urgency (Low, Medium, High)
* Status update prevention for already resolved tickets
* Max ticket limit

---
