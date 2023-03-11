import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class atm extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel labelPin, labelAmount;
    private JTextField textPin, textAmount;
    private JButton buttonWithdraw, buttonDeposit;

    public atm() {
        setTitle("ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(3, 2, 5, 5));

        labelPin = new JLabel("PIN:");
        add(labelPin);

        textPin = new JTextField(10);
        add(textPin);

        labelAmount = new JLabel("Amount:");
        add(labelAmount);

        textAmount = new JTextField(10);
        add(textAmount);

        buttonWithdraw = new JButton("Withdraw");
        buttonWithdraw.addActionListener(this);
        add(buttonWithdraw);

        buttonDeposit = new JButton("Deposit");
        buttonDeposit.addActionListener(this);
        add(buttonDeposit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonWithdraw) {
            String pin = textPin.getText();
            String amount = textAmount.getText();

            // Check if PIN and amount are valid
            if (pin.equals("1234") && !amount.isEmpty()) {
                double balance = 1000; // Assume starting balance of $1000
                double withdrawAmount = Double.parseDouble(amount);

                // Check if balance is sufficient for the withdrawal
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance is $" + balance);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid PIN or amount.");
            }
        } else if (e.getSource() == buttonDeposit) {
            String pin = textPin.getText();
            String amount = textAmount.getText();

            // Check if PIN and amount are valid
            if (pin.equals("1234") && !amount.isEmpty()) {
                double balance = 1000; // Assume starting balance of $1000
                double depositAmount = Double.parseDouble(amount);

                balance += depositAmount;
                JOptionPane.showMessageDialog(null, "Deposit successful. New balance is $" + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid PIN or amount.");
            }
        }
    }

    public static void main(String[] args) {
        new atm();
    }
}
