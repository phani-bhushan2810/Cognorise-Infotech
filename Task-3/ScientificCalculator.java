import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame {
    private JTextField display;
    private String currentInput = "";
    private double storedValue = 0;
    private char currentOperation = ' ';

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create display area
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // Create buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "DEL", "sqrt", "^",
            "sin", "cos", "tan", "log"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("\\d") || command.equals(".")) {
                currentInput += command;
                display.setText(currentInput);
            } else if (command.equals("C")) {
                currentInput = "";
                storedValue = 0;
                currentOperation = ' ';
                display.setText("");
            } else if (command.equals("DEL")) {
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                    display.setText(currentInput);
                }
            } else if (command.equals("=")) {
                if (!currentInput.isEmpty() && currentOperation != ' ') {
                    double currentValue = Double.parseDouble(currentInput);
                    double result = applyOperation(storedValue, currentValue, currentOperation);
                    display.setText(String.valueOf(result));
                    currentInput = "";
                    storedValue = result;
                    currentOperation = ' ';
                }
            } else {
                if (!currentInput.isEmpty()) {
                    storedValue = Double.parseDouble(currentInput);
                    currentInput = "";
                }
                if (command.equals("sqrt")) {
                    double result = Math.sqrt(storedValue);
                    display.setText(String.valueOf(result));
                    storedValue = result;
                } else if (command.equals("sin")) {
                    double result = Math.sin(Math.toRadians(storedValue));
                    display.setText(String.valueOf(result));
                    storedValue = result;
                } else if (command.equals("cos")) {
                    double result = Math.cos(Math.toRadians(storedValue));
                    display.setText(String.valueOf(result));
                    storedValue = result;
                } else if (command.equals("tan")) {
                    double result = Math.tan(Math.toRadians(storedValue));
                    display.setText(String.valueOf(result));
                    storedValue = result;
                } else if (command.equals("log")) {
                    double result = Math.log10(storedValue);
                    display.setText(String.valueOf(result));
                    storedValue = result;
                } else {
                    currentOperation = command.charAt(0);
                }
            }
        }

        private double applyOperation(double a, double b, char op) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0) {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                        return 0;
                    }
                    return a / b;
                case '^':
                    return Math.pow(a, b);
                default:
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScientificCalculator calculator = new ScientificCalculator();
            calculator.setVisible(true);
        });
    }
}
