import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField numField1;
    private JTextField numField2;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JTextField resultField;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setLayout(new FlowLayout());

        numField1 = new JTextField(10);
        numField2 = new JTextField(10);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        frame.add(numField1);
        frame.add(numField2);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(resultField);

        addButton.addActionListener(new OperatorListener('+'));
        subtractButton.addActionListener(new OperatorListener('-'));
        multiplyButton.addActionListener(new OperatorListener('*'));
        divideButton.addActionListener(new OperatorListener('/'));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private class OperatorListener implements ActionListener {
        private char operator;

        public OperatorListener(char operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(frame, "Error: Division by zero.");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            resultField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}
