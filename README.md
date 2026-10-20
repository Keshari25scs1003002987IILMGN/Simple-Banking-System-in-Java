# Simple Banking System in Java

A console-based banking application built with core Java. It supports account creation, secure login with a PIN, and basic transactions.

## Features
- Create a new account with an initial deposit and a 4-digit PIN
- Login using account number and PIN
- Check balance
- Deposit and withdraw money
- Transfer money between accounts
- View transaction history with timestamps
- Input validation and error handling (insufficient balance, invalid amounts, wrong PIN)

## Project Structure
```
Simple-Banking-System-in-Java/
├── src/
│   ├── Main.java          # Console menu and user interaction
│   ├── Bank.java          # Account creation, login, transfers
│   ├── Account.java       # Account data, deposit, withdraw
│   └── Transaction.java   # Transaction record
├── .gitignore
└── README.md
```

## Concepts Used
OOP (encapsulation, abstraction), collections (`HashMap`, `ArrayList`), exception handling, `java.time`, and `Scanner` for console I/O.

## How to Run
Requires JDK 8 or higher.

```bash
git clone https://github.com/<your-username>/Simple-Banking-System-in-Java.git
cd Simple-Banking-System-in-Java
mkdir out
javac -d out src/*.java
java -cp out Main
```

## Sample Run
```
=== SIMPLE BANKING SYSTEM ===
1. Create Account
2. Login
3. Exit
```

## Author
Keshari Nandan Ray - Cyrostack Internship Project
