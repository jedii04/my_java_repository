import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6SwingToDoList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoListViewer());
    }
}

// Main Window - To-Do List Viewer
class ToDoListViewer extends JFrame {
    DefaultTableModel tableModel;
    JTable table;
    JButton addTaskButton;
    ToDoListForm formWindow;

    public ToDoListViewer() {
        setTitle("To-Do List Viewer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Column names ng table
        String[] columnNames = {"Task Name", "Task Description", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hindi puwedeng i-edit ang mga cells
            }
        };

        table = new JTable(tableModel);

        // Optional: Adjust column width para di masyadong malaki
        table.getColumnModel().getColumn(1).setPreferredWidth(100); // Task Name
        table.getColumnModel().getColumn(1).setPreferredWidth(200); // Description
        table.getColumnModel().getColumn(1).setPreferredWidth(80);  // Status

        JScrollPane scrollPane = new JScrollPane(table);

        // Button para mag-add ng task
        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(e -> openForm());

        // Layout ng top part (button area)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(addTaskButton);

        add(topPanel, BorderLayout.NORTH); // button sa taas
        add(scrollPane, BorderLayout.CENTER); // table sa gitna

        setVisible(true);
    }

    // Function na magbubukas ng form window
    private void openForm() {
        if (formWindow == null || !formWindow.isDisplayable()) {
            formWindow = new ToDoListForm(this);
        } else {
            formWindow.toFront(); // kung bukas na, bring to front na lang
        }
    }

    // Method para mag-add ng row sa table
    public void addTask(String name, String description, String status) {
        tableModel.addRow(new Object[]{name, description, status});
    }
}

// Second Window - Form for Adding Task
class ToDoListForm extends JFrame {
    private JTextField taskNameField;
    private JTextArea taskDescriptionArea;
    private JComboBox<String> statusComboBox;
    private JButton saveButton;
    ToDoListViewer viewer;

    public ToDoListForm(ToDoListViewer viewer) {
        this.viewer = viewer;

        setTitle("Add New Task");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Form layout: input fields
        JPanel formPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        taskNameField = new JTextField();
        taskDescriptionArea = new JTextArea(3, 20);
        JScrollPane descriptionScroll = new JScrollPane(taskDescriptionArea);
        statusComboBox = new JComboBox<>(new String[]{"Not Started", "Ongoing", "Completed"});

        formPanel.add(new JLabel("Task Name:"));
        formPanel.add(taskNameField);
        formPanel.add(new JLabel("Task Description:"));
        formPanel.add(descriptionScroll);
        formPanel.add(new JLabel("Status:"));
        formPanel.add(statusComboBox);

        // Save button
        saveButton = new JButton("Save Task");
        saveButton.addActionListener(new SaveButtonListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);

        add(formPanel, BorderLayout.CENTER); // form inputs
        add(buttonPanel, BorderLayout.SOUTH); // save button sa baba

        setVisible(true);

        // Para mag-reset yung formWindow variable pag sinara yung window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                viewer.formWindow = null;
            }

            @Override
            public void windowClosing(WindowEvent e) {
                viewer.formWindow = null;
            }
        });
    }

    // Kapag na-click yung Save button
    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String taskName = taskNameField.getText().trim();
            String taskDescription = taskDescriptionArea.getText().trim();
            String status = (String) statusComboBox.getSelectedItem();

            // Check kung may laman yung fields
            if (!taskName.isEmpty() && !taskDescription.isEmpty()) {
                viewer.addTask(taskName, taskDescription, status);
                dispose(); // isara yung form window
            } else {
                JOptionPane.showMessageDialog(ToDoListForm.this, "Please fill in Task Name and Status.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
