import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private double balance;
    private ArrayList<String> history;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        history = new ArrayList<>();
        history.add("Account created with ₹" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited ₹" + amount);
            System.out.println("✅ Deposit Successful!");
        } else {
            System.out.println("❌ Invalid Amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid Amount!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            history.add("Withdrawn ₹" + amount);
            System.out.println("✅ Withdrawal Successful!");
        }
    }

    public void checkBalance() {
        System.out.println("\n💰 Current Balance: ₹" + balance);
    }

    public void showHistory() {
        System.out.println("\n===== TRANSACTION HISTORY =====");
        for (String record : history) {
            System.out.println(record);
        }
    }
}

class ATM {
    private BankAccount account;
    private final int pin = 1234;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      WELCOME TO ATM SYSTEM     ");
        System.out.println("================================");

        System.out.print("Enter ATM PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("❌ Incorrect PIN!");
            return;
        }

        int choice;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Amount to Deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Amount to Withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    account.showHistory();
                    break;

                case 5:
                    System.out.println("🙏 Thank You For Using Our ATM!");
                    break;

                default:
                    System.out.println("❌ Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        ATM atm = new ATM(account);
        atm.start();
    }
}
