import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {
    // Labels at TextField para sa inputs ng user
    Label lblFirstName, lblLastName, lblAge, lblHoursWorked, lblHourlyRate;
    TextField txtFirstName, txtLastName, txtAge, txtHoursWorked, txtHourlyRate;

    // Button para sa submission
    Button btnSubmit;

    // TextArea para sa output display
    TextArea outputArea;

    public LabActivity4EmpInfoSystemGUI() {
        // Title ng window
        setTitle("Laboratory Activity 4");
        setSize(500, 500);
        setLayout(new BorderLayout(10, 10));

        // Panel para sa form inputs
        Panel formPanel = new Panel(new GridLayout(5, 2, 5, 5));
        
        // Labels at TextFields para sa employee info
        lblFirstName = new Label("First Name");
        txtFirstName = new TextField();

        lblLastName = new Label("Last Name");
        txtLastName = new TextField();

        lblAge = new Label("Age");
        txtAge = new TextField();

        lblHoursWorked = new Label("Hours Worked");
        txtHoursWorked = new TextField();

        lblHourlyRate = new Label("Hourly Rate");
        txtHourlyRate = new TextField();

        // Add natin lahat sa form panel
        formPanel.add(lblFirstName); formPanel.add(txtFirstName);
        formPanel.add(lblLastName); formPanel.add(txtLastName);
        formPanel.add(lblAge); formPanel.add(txtAge);
        formPanel.add(lblHoursWorked); formPanel.add(txtHoursWorked);
        formPanel.add(lblHourlyRate); formPanel.add(txtHourlyRate);

        // Panel para sa button
        Panel buttonPanel = new Panel();
        btnSubmit = new Button("Submit");
        btnSubmit.addActionListener(this); // I-connect natin 'yung action
        buttonPanel.add(btnSubmit);

        // Panel para sa output section
        Panel outputPanel = new Panel(new BorderLayout(5, 5));
        Panel labelPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label lblOutput = new Label("Output:");
        labelPanel.add(lblOutput);

        // TextArea kung saan lalabas ang result
        outputArea = new TextArea("", 5, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        outputArea.setEditable(false); // read-only dapat 'to

        // Add natin ang label at textarea sa output panel
        outputPanel.add(labelPanel, BorderLayout.NORTH);
        outputPanel.add(outputArea, BorderLayout.CENTER);

        // Add lahat ng panels sa main frame
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        // Para magsara 'yung window properly kapag pinindot ang X
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); // para mag-close yung window ng maayos
            }
        });

        // Para lumabas agad 'yung GUI window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outputArea.setText(""); // Clear muna natin yung output area

        // Kunin natin lahat ng inputs from user
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String ageStr = txtAge.getText().trim();
        String hoursStr = txtHoursWorked.getText().trim();
        String rateStr = txtHourlyRate.getText().trim();

        // Check kung may kulang na fields
        if (firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty()
                || hoursStr.isEmpty() || rateStr.isEmpty()) {
            outputArea.setText("Error: All fields must be filled out.");
            return;
        }

        int age = 0;
        double hoursWorked = 0;
        double hourlyRate = 0;

        // Try i-parse ang Age (dapat integer)
        try {
            age = Integer.parseInt(ageStr);
            if (age <= 0) {
                outputArea.setText("Error: Age must be greater than 0.");
                return;
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Age must be a valid integer.");
            return;
        }

        // Try i-parse ang Hours Worked at Hourly Rate (dapat numbers)
        try {
            hoursWorked = Double.parseDouble(hoursStr);
            hourlyRate = Double.parseDouble(rateStr);

            if (hoursWorked < 0 || hourlyRate < 0) {
                outputArea.setText("Error: Hours Worked and Hourly Rate must be non-negative.");
                return;
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Hours worked and hourly rate must be valid numbers.");
            return;
        }

        // Compute natin ang result kapag okay lahat ng inputs
        String fullName = firstName + " " + lastName;
        double dailyWage = hoursWorked * hourlyRate;

        // Ipakita natin ang final output
        outputArea.setText("Full Name: " + fullName + "\n" +
                           "Age: " + age + " years old\n" +
                           "Daily Salary: PHP " + String.format("%.2f", dailyWage));
    }

    public static void main(String[] args) {
        // Tawagin lang para mag-run ang GUI
        new LabActivity4EmpInfoSystemGUI();
    }
}
