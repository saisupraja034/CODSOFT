import java.util.Scanner;
interface ATMOperations {
    void withdraw(double amount);
    void deposit(double amount);
    void checkBalance();
}
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Error: Balance cannot be negative!");
            return;
        }
        this.balance = balance;
    }
}
class ATM implements ATMOperations {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance!");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful! New balance: " + account.getBalance());
        }
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful! New balance: " + account.getBalance());
        }
    }

    
    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }
}
public class Atmsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount myAccount = new BankAccount(5000); // starting balance
        ATM atm = new ATM(myAccount);

        while (true) {
            System.out.println(" ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    atm.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    atm.withdraw(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

