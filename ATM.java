import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM extends Frame implements ActionListener {
    private BankAccount account;
    private TextField amountField;
    private Label balanceLabel;

    public ATM(BankAccount acc) {
        account = acc;

        Label amountLabel = new Label("Enter amount:");
        amountField = new TextField(10);

        Button withdrawButton = new Button("Withdraw");
        Button depositButton = new Button("Deposit");
        Button balanceButton = new Button("Check Balance");

        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);
        balanceButton.addActionListener(this);

        balanceLabel = new Label("Balance: $" + account.getBalance());

        setLayout(new FlowLayout());
        add(amountLabel);
        add(amountField);
        add(withdrawButton);
        add(depositButton);
        add(balanceButton);
        add(balanceLabel);

        setTitle("ATM Machine");
        setSize(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        double amount = Double.parseDouble(amountField.getText());

        switch (command) {
            case "Withdraw":
                if (account.withdraw(amount)) {
                    balanceLabel.setText("Balance: $" + account.getBalance());
                    showMessage("Withdrawal successful.");
                } else {
                    showMessage("Insufficient balance.");
                }
                break;
            case "Deposit":
                account.deposit(amount);
                balanceLabel.setText("Balance: $" + account.getBalance());
                showMessage("Deposit successful.");
                break;
            case "Check Balance":
                showMessage("Your balance is: $" + account.getBalance());
                break;
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000.0);
        new ATM(acc);
    }
}
