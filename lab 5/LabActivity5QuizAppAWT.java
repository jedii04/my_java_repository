import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame implements ActionListener {

    Label questionLabel;
    CheckboxGroup group;
    Checkbox[] options = new Checkbox[4];
    Label messageLabel;
    Button nextButton;

    // Mga tanong
    String[] questions = {
        "Which data structure uses LIFO (Last In First Out)?",
        "What is the main role of the CPU in a computer?",
        "Which protocol is used to send emails?"
    };

    // Mga pagpipilian sa bawat tanong
    String[][] choices = {
        {"A. Queue", "B. Stack", "C. Array", "D. Tree"},
        {"A. Store data", "B. Display images", "C. Perform calculations", "D. Connect to internet"},
        {"A. FTP", "B. HTTP", "C. SMTP", "D. IP"}
    };

    // Tamang sagot (index-based)
    int[] correctAnswers = {1, 2, 2}; // B, C, C

    int current = 0, score = 0;

    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(null);
        setResizable(false); // Para hindi ma-resize ang window
        setLocationRelativeTo(null); // Center sa screen

        // Top border na dark blue
        Panel topBorder = new Panel();
        topBorder.setBackground(new Color(0, 20, 40)); // Mas darker na blue
        topBorder.setBounds(0, 0, 500, 30);
        add(topBorder);

        // Label para sa tanong
        questionLabel = new Label("", Label.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setBounds(50, 40, 400, 30);
        add(questionLabel);

        // Group ng mga checkbox (para isang option lang ang pwede)
        group = new CheckboxGroup();

        // Mga options (A, B, C, D)
        options[0] = new Checkbox("", group, false);
        options[0].setBounds(10, 102, 180, 20);
        options[0].setForeground(Color.BLUE);
        options[0].setFont(new Font("Dialog", Font.PLAIN, 16));
        add(options[0]);

        options[1] = new Checkbox("", group, false);
        options[1].setBounds(250, 102, 180, 20);
        options[1].setForeground(Color.BLUE);
        options[1].setFont(new Font("Dialog", Font.PLAIN, 16));
        add(options[1]);

        options[2] = new Checkbox("", group, false);
        options[2].setBounds(10, 182, 180, 20);
        options[2].setForeground(Color.BLUE);
        options[2].setFont(new Font("Dialog", Font.PLAIN, 16));
        add(options[2]);

        options[3] = new Checkbox("", group, false);
        options[3].setBounds(250, 182, 180, 20);
        options[3].setForeground(Color.BLUE);
        options[3].setFont(new Font("Dialog", Font.PLAIN, 16));
        add(options[3]);

        // Label para sa message (validation)
        messageLabel = new Label("", Label.CENTER);
        messageLabel.setBounds(50, 237, 400, 20);
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setAlignment(Label.CENTER);
        add(messageLabel);

        // Button para sa "Next"
        nextButton = new Button("Next");
        nextButton.setBounds(0, 260, 500, 40); // Full width
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);
        nextButton.addActionListener(this);
        add(nextButton);

        // Para kapag pinindot ang close button ng window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // Isara ang app
            }
        });

        // Load ang unang tanong
        loadQuestion();
        setVisible(true);
    }

    void loadQuestion() {
        if (current < questions.length) {
            // I-set ang tanong
            questionLabel.setText(questions[current]);
            group.setSelectedCheckbox(null); // I-unselect ang previous na checkbox

            // I-update ang choices
            for (int i = 0; i < 4; i++) {
                options[i].setLabel(choices[current][i]);
                options[i].setState(false);
                options[i].setEnabled(true);
            }

            messageLabel.setText(""); // I-clear ang message
        } else {
            // Kapag tapos na ang quiz
            questionLabel.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length);
            for (Checkbox cb : options) {
                cb.setEnabled(false); // Disable lahat ng choices
            }
            nextButton.setEnabled(false); // Disable ang Next button
            messageLabel.setText(""); // I-clear ang message
        }
    }

    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        // Hanapin kung alin ang napiling choice
        for (int i = 0; i < 4; i++) {
            if (options[i].getState()) {
                selected = i;
                break;
            }
        }

        // Kung walang pinili
        if (selected == -1) {
            messageLabel.setText("Please select an answer.");
            return;
        }

        // I-check kung tama ang sagot
        if (selected == correctAnswers[current]) {
            score++;
        }

        current++;
        loadQuestion(); // Load next question
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}
