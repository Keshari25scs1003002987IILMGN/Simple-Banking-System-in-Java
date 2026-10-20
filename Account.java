import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String accountNumber;
    private final String holderName;
    private final String pin;
    private double balance;
    private final List<Transaction> history = new ArrayList<>();

    public Account(String accountNumber, String holderName, String pin, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.pin = pin;
        this.balance = initialDeposit;
        history.add(new Transaction("ACCOUNT OPENED", initialDeposit, balance));
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public List<Transaction> getHistory() { return history; }

    public boolean verifyPin(String input) {
        return pin.equals(input);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
        history.add(new Transaction("DEPOSIT", amount, balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance) throw new IllegalStateException("Insufficient balance.");
        balance -= amount;
        history.add(new Transaction("WITHDRAWAL", amount, balance));
    }

    void receiveTransfer(double amount, String from) {
        balance += amount;
        history.add(new Transaction("TRANSFER IN", amount, balance));
    }

    void sendTransfer(double amount, String to) {
        if (amount > balance) throw new IllegalStateException("Insufficient balance.");
        balance -= amount;
        history.add(new Transaction("TRANSFER OUT", amount, balance));
    }
}
