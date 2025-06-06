import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
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
        setSize(600, 400); // Sapat para sa 3 columns na pantay
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Column names ng table
        String[] columnNames = {"Task Name", "Task Description", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hindi ma-eedit ang cells
            }
        };

        table = new JTable(tableModel);

        // Auto-resize all columns 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Pantay na width ng tatlong columns
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);

        // Scroll pane sa table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add Task button
        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(e -> openForm());

        // Top panel para sa button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(addTaskButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Function na magbubukas ng form window
    private void openForm() {
        if (formWindow == null || !formWindow.isDisplayable()) {
            formWindow = new ToDoListForm(this);
        } else {
            formWindow.toFront();
        }
    }

    // Add row to the table
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

        // Input fields
        JPanel formPanel = new JPanel(new GridLayout(8, 1, 5, 5));
        taskNameField = new JTextField();
        taskDescriptionArea = new JTextArea(5, 20);
        taskDescriptionArea.setLineWrap(true);
        taskDescriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScroll = new JScrollPane(taskDescriptionArea);
        statusComboBox = new JComboBox<>(new String[]{"Not Started", "Ongoing", "Completed"});

        formPanel.add(new JLabel("Task Name:"));
        formPanel.add(taskNameField);
        formPanel.add(new JLabel("Task Description:"));
        formPanel.add(descriptionScroll);
        formPanel.add(new JLabel("Status:"));
        formPanel.add(statusComboBox);

        // Padding
        JPanel paddedPanel = new JPanel(new BorderLayout());
        paddedPanel.setBorder(new EmptyBorder(10, 15, 10, 15));
        paddedPanel.add(formPanel, BorderLayout.CENTER);

        // Save button
        saveButton = new JButton("Save Task");
        saveButton.addActionListener(new SaveButtonListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);

        add(paddedPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

        // Reset formWindow variable sa main window
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

    // Save Button logic
    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String taskName = taskNameField.getText().trim();
            String taskDescription = taskDescriptionArea.getText().trim();
            String status = (String) statusComboBox.getSelectedItem();

            if (!taskName.isEmpty() && !taskDescription.isEmpty()) {
                viewer.addTask(taskName, taskDescription, status);
                dispose();
            } else {
                JOptionPane.showMessageDialog(ToDoListForm.this,
                        "Please fill in Task Name and Status.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
