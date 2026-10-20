import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();
    private int nextNumber = 1001;

    public Account createAccount(String name, String pin, double initialDeposit) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        if (!pin.matches("\\d{4}"))
            throw new IllegalArgumentException("PIN must be exactly 4 digits.");
        if (initialDeposit < 0)
            throw new IllegalArgumentException("Initial deposit cannot be negative.");

        String accNo = "ACC" + nextNumber++;
        Account acc = new Account(accNo, name.trim(), pin, initialDeposit);
        accounts.put(accNo, acc);
        return acc;
    }

    public Account login(String accNo, String pin) {
        Account acc = accounts.get(accNo);
        if (acc == null || !acc.verifyPin(pin))
            throw new IllegalArgumentException("Invalid account number or PIN.");
        return acc;
    }

    public void transfer(Account from, String toAccNo, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive.");
        Account to = accounts.get(toAccNo);
        if (to == null) throw new IllegalArgumentException("Recipient account not found.");
        if (to == from) throw new IllegalArgumentException("Cannot transfer to the same account.");
        from.sendTransfer(amount, toAccNo);
        to.receiveTransfer(amount, from.getAccountNumber());
    }
}
