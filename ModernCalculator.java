import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModernCalculator extends JFrame implements ActionListener {

    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0;

    public ModernCalculator() {

        // Frame settings
        setTitle("Modern Calculator");
        setSize(320, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setFont(new Font("Segoe UI", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btn.setBackground(Color.GRAY);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        }
        else if (cmd.equals("C")) {
            display.setText("");
            operator = "";
            num1 = num2 = 0;
        }
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case "+": num1 += num2; break;
                case "-": num1 -= num2; break;
                case "*": num1 *= num2; break;
                case "/": num1 /= num2; break;
            }
            display.setText(String.valueOf(num1));
            operator = "";
        }
        else {
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new ModernCalculator();
    }
}