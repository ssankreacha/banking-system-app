import java.io.*;
import java.util.*;

class BankAccount implements Serializable {
    private String username;
    private String accountType;
    private double balance;
    private String pin;
    private List<String> transactionHistory;

    // Interest rate for savings account
    private static final double INTEREST_RATE = 0.03; // 3% Annual Interest

    // Constructor
    public BankAccount(String username, String pin, String accountType) {
        this.username = username;
        this.pin = pin;
        this.accountType = accountType;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    // Getters
    public String getUsername() { return username; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public String getPin() { return pin; }
    public List<String> getTransactionHistory() { return transactionHistory; }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("✅ Deposit successful! New Balance: $" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("✅ Withdrawal successful! New Balance: $" + balance);
        } else {
            System.out.println("❌ Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Display transaction history
    public void showTransactionHistory() {
        System.out.println("\n📜 Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Interest Calculation (for Savings Accounts)
    public void applyInterest() {
        if (accountType.equalsIgnoreCase("savings")) {
            double interest = balance * INTEREST_RATE;
            balance += interest;
            transactionHistory.add("Interest Applied: $" + interest);
            System.out.println("✅ Interest Applied! New Balance: $" + balance);
        } else {
            System.out.println("❌ Interest only applies to Savings Accounts.");
        }
    }
}

public class BankingSystem {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static final String DATA_FILE = "bank_accounts.dat";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadAccounts();  // Load existing accounts from file

        System.out.println("🏦 Welcome to the Banking System!");
        while (true) {
            System.out.println("\n1️⃣ Login");
            System.out.println("2️⃣ Create New Account");
            System.out.println("3️⃣ Exit");
            System.out.print("➡️ Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: login(); break;
                case 2: createAccount(); break;
                case 3:
                    saveAccounts(); // Save data before exit
                    System.out.println("🔚 Exiting system. Have a great day!");
                    System.exit(0);
                default: System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    // Create a new account
    private static void createAccount() {
        System.out.print("\n🆕 Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("🔑 Set a 4-digit PIN: ");
        String pin = scanner.nextLine();

        System.out.print("🏦 Choose Account Type (Savings/Checking): ");
        String accountType = scanner.nextLine();

        if (!accountType.equalsIgnoreCase("savings") && !accountType.equalsIgnoreCase("checking")) {
            System.out.println("❌ Invalid account type. Please enter 'Savings' or 'Checking'.");
            return;
        }

        if (accounts.containsKey(username)) {
            System.out.println("❌ Username already exists. Try another.");
        } else {
            BankAccount newAccount = new BankAccount(username, pin, accountType);
            accounts.put(username, newAccount);
            System.out.println("✅ Account created successfully!");
        }
    }

    // Login to an existing account
    private static void login() {
        System.out.print("\n👤 Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("🔑 Enter PIN: ");
        String pin = scanner.nextLine();

        BankAccount account = accounts.get(username);
        if (account != null && account.getPin().equals(pin)) {
            System.out.println("✅ Login Successful! Welcome, " + username);
            bankingMenu(account);
        } else {
            System.out.println("❌ Invalid username or PIN. Try again.");
        }
    }

    // Banking operations menu
    private static void bankingMenu(BankAccount account) {
        while (true) {
            System.out.println("\n💰 Banking Menu for " + account.getUsername());
            System.out.println("1️⃣ Deposit Money");
            System.out.println("2️⃣ Withdraw Money");
            System.out.println("3️⃣ Check Balance");
            System.out.println("4️⃣ View Transaction History");
            System.out.println("5️⃣ Apply Interest (Savings Only)");
            System.out.println("6️⃣ Logout");
            System.out.print("➡️ Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("💵 Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("💸 Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("🏦 Your Balance: $" + account.getBalance());
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    account.applyInterest();
                    break;
                case 6:
                    saveAccounts();
                    System.out.println("👋 Logged out.");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    // Save accounts to a file
    private static void saveAccounts() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("❌ Error saving accounts: " + e.getMessage());
        }
    }

    // Load accounts from a file
    private static void loadAccounts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            accounts = (Map<String, BankAccount>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("📂 No previous account data found. Starting fresh.");
        }
    }
}
