import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        System.out.println("=== SIMPLE BANKING SYSTEM ===");
        while (true) {
            System.out.println("\n1. Create Account\n2. Login\n3. Exit");
            int choice = readInt("Choose an option: ");
            try {
                switch (choice) {
                    case 1: createAccount(); break;
                    case 2: login(); break;
                    case 3:
                        System.out.println("Thank you for banking with us!");
                        return;
                    default: System.out.println("Invalid option.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Set a 4-digit PIN: ");
        String pin = sc.nextLine();
        double deposit = readDouble("Initial deposit: ");
        Account acc = bank.createAccount(name, pin, deposit);
        System.out.println("Account created! Your account number is: " + acc.getAccountNumber());
    }

    private static void login() {
        System.out.print("Account number: ");
        String accNo = sc.nextLine().trim().toUpperCase();
        System.out.print("PIN: ");
        String pin = sc.nextLine();
        Account acc = bank.login(accNo, pin);
        System.out.println("Welcome, " + acc.getHolderName() + "!");
        accountMenu(acc);
    }

    private static void accountMenu(Account acc) {
        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Transaction History\n6. Logout");
            int choice = readInt("Choose an option: ");
            try {
                switch (choice) {
                    case 1:
                        System.out.printf("Balance: Rs. %.2f%n", acc.getBalance());
                        break;
                    case 2:
                        acc.deposit(readDouble("Amount to deposit: "));
                        System.out.println("Deposit successful.");
                        break;
                    case 3:
                        acc.withdraw(readDouble("Amount to withdraw: "));
                        System.out.println("Withdrawal successful.");
                        break;
                    case 4:
                        System.out.print("Recipient account number: ");
                        String to = sc.nextLine().trim().toUpperCase();
                        bank.transfer(acc, to, readDouble("Amount to transfer: "));
                        System.out.println("Transfer successful.");
                        break;
                    case 5:
                        acc.getHistory().forEach(System.out::println);
                        break;
                    case 6:
                        System.out.println("Logged out.");
                        return;
                    default: System.out.println("Invalid option.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        try { return Double.parseDouble(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }
}
