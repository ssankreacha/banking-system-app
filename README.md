# 🏦 Java Banking System

A console-based banking application that allows users to **deposit money, withdraw funds, check balances, and more**.

---

## 📌 Features

### ✅ 1. Simplified Version
- Deposit Money 💰  
- Withdraw Money 💸  
- Check Balance 🏦  
- Console-Based UI 📟  

### ✅ 2. Advanced Version
- **Login System** (Username & PIN) 🔑  
- **Transaction History** 📜  
- **Account Types** (Savings & Checking) 🏦  
- **Interest Calculation** (for Savings Accounts) 💡  
- **File-Based Data Persistence** (Saves accounts) 💾  

---

## 📌 Installation & Setup

### 1️⃣ Requirements
- **Java 8 or higher** installed on your system.  
- **A Java IDE** (e.g., IntelliJ IDEA, Eclipse, VS Code) or command line.  

---

## 📌 How to Use

### 1️⃣ Simplified Version

Run the program using the command above.
Choose an option:
- **1 → Deposit Money**
- **2 → Withdraw Money**
- **3 → Check Balance**
- **4 → Exit**
- **Enter amounts for deposits/withdrawals.**
- **The balance updates accordingly.**

---

### 2️⃣ Advanced Version
Run the program using the command above.
Choose an option:
- **1 → Login**
- **2 → Create a New Account**
- **3 → Exit**

If creating an account:
- **Enter a Username & 4-digit PIN.**
- **Select Savings or Checking account.**

If logging in:
- **Enter the correct Username & PIN.**

Access the banking menu:
- **Deposit 💰**
- **Withdraw 💸**
- **Check Balance 🏦**
- **View Transactions 📜**
- **Apply Interest (Savings) 💡**
- **Logout 🔚**

The program saves all account data to a file (bank_accounts.dat) for future access.

---

## 📌 File Storage (Advanced Version)
- **The Advanced Banking System stores account details in a file (bank_accounts.dat) so users can access balances & history even after restarting.**

### How Data is Stored
- **The program automatically loads account data on startup and saves changes when exiting.**

---

## 📌 Future Improvements
- **Add Graphical User Interface (GUI) for better user experience.**
- **Implement database storage instead of file-based persistence.**
- **Introduce fund transfers between users.**
