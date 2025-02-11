import java.util.Scanner;

class BankAccount {
    private double balance; // Stores the account balance

    // Constructor (initializes balance to 0)
    public BankAccount() {
        this.balance = 0.0;
    }

    // Deposit Method (Adds money to the balance)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit successful! New Balance: $" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw Method (Deducts money from balance)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawal successful! New Balance: $" + balance);
        } else {
            System.out.println("❌ Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Check Balance Method (Displays current balance)
    public void checkBalance() {
        System.out.println("🏦 Your current balance: $" + balance);
    }
}

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        BankAccount userAccount = new BankAccount(); // Creates a new bank account

        System.out.println("🏦 Welcome to the Simple Banking System!");

        // Banking Menu (Loops until user chooses to exit)
        while (true) {
            System.out.println("\n1️⃣ Deposit Money");
            System.out.println("2️⃣ Withdraw Money");
            System.out.println("3️⃣ Check Balance");
            System.out.println("4️⃣ Exit");
            System.out.print("➡️ Choose an option: ");

            int choice = scanner.nextInt(); // Reads user input

            switch (choice) {
                case 1:
                    System.out.print("💵 Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("💸 Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    userAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using our banking system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice. Please select a valid option.");
            }
        }
    }
}
