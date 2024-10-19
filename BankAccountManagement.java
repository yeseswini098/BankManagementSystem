import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class BankAccountManagement {
    private static Map<String, Account> accounts = new HashMap<>();
    private static SecureRandom random = new SecureRandom();

    static class Account {
        private String accountNumber;
        private String accountHolderName;
        private double balance;

        public Account(String accountNumber, String accountHolderName) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = 0.0; // Initial balance
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount + " to account " + accountNumber);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        }

        public double getBalance() {
            return balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }
    }

    public static void main(String[] args) {
        // Create a predefined number of accounts
        for (int i = 0; i < 5; i++) { // Change 5 to any number of accounts you want
            String accountNumber = generateRandomAccountNumber();
            String accountHolderName = "AccountHolder" + (i + 1);
            Account newAccount = new Account(accountNumber, accountHolderName);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created: " + accountHolderName + " with account number: " + accountNumber);
        }

        // Example operations
        performRandomOperations();
    }

    private static String generateRandomAccountNumber() {
        return String.valueOf(100000 + random.nextInt(900000)); // Generates a random 6-digit account number
    }

    private static void performRandomOperations() {
        for (Account account : accounts.values()) {
            account.deposit(random.nextInt(1000) + 1); // Random deposit between 1 and 1000
            account.withdraw(random.nextInt(500)); // Random withdrawal up to 500
            System.out.println("Current balance for account " + account.getAccountNumber() + ": " + account.getBalance());
        }
    }
}