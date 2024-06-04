import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String name;
    private double balance;
    private String email;

    public BankAccount(String accountNumber, String name, String email) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0.0;
        this.email = email;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposit of " + amount + " rupee is successful.");
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\n" + amount + " rupee is withdrawal from your account");
        } else {
            System.out.println("\nInsufficient amount!");
        }
    }

    public void displayAccount() {
        System.out.println("\nACCOUNT DETAILS:");
        System.out.println("........................................................................");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Balance: " + balance + " rupee");
        System.out.println("Email: " + email);
        System.out.println("........................................................................");
    }
}

public class miniBank {
    private static Map<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************************************************************************");
        System.out.println("Welcome to our bank!!");
        System.out.println("**************************************************************************");
        System.out.println("------MINIBANK-----");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new account");
            System.out.println("2. Access an existing account");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter your account number: ");
                String accountNumber = scanner.nextLine();

                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                System.out.print("Enter your email: ");
                String email = scanner.nextLine();

                BankAccount account = new BankAccount(accountNumber, name, email);
                accounts.put(accountNumber, account);

                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);

                System.out.println("\nAccount created successfully!");
                System.out.println("........................................................................");
                account.displayAccount();

            } else if (choice == 2) {
                System.out.print("Enter your account number: ");
                String accountNumber = scanner.nextLine();

                BankAccount account = accounts.get(accountNumber);

                if (account != null) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Display account details");
                    System.out.println("4. Exit");

                    int accountChoice = scanner.nextInt();

                    switch (accountChoice) {
                        case 1:
                            System.out.print("Enter the amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            break;

                        case 2:
                            System.out.print("Enter the amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdrawal(withdrawAmount);
                            break;

                        case 3:
                            account.displayAccount();
                            break;

                        case 4:
                            break;
                    }

                } else {
                    System.out.println("Account not found!");
                }

            } else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }
}

