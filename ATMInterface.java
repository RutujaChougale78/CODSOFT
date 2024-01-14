package Game;
import java.util.Scanner;
class BankAccount {
	private double balance;
		public BankAccount(double initialBalance) {
		    this.balance = initialBalance;
		    }

		    public double getBalance() {
		        return balance;
		    }

		    public void deposit(double amount) {
		        balance += amount;
		        System.out.println("Deposit successful. New balance: $" + balance);
		    }

		    public boolean withdraw(double amount) {
		        if (amount > balance) {
		            System.out.println("Insufficient funds. Withdrawal failed.");
		            return false;
		        }

		        balance -= amount;
		        System.out.println("Withdrawal successful. New balance: $" + balance);
		        return true;
		    }
		}

		class ATM {
		    private BankAccount bankAccount;

		    public ATM(BankAccount bankAccount) {
		        this.bankAccount = bankAccount;
		    }

		    public void deposit(double amount) {
		        bankAccount.deposit(amount);
		    }

		    public void withdraw(double amount) {
		        if (bankAccount.withdraw(amount)) {
		            System.out.println("Please take your cash.");
		        }
		    }

		    public void checkBalance() {
		        System.out.println("Current balance: $" + bankAccount.getBalance());
		    }
		}

		public class ATMInterface {

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        BankAccount bankAccount = new BankAccount(1000);
		        ATM atm = new ATM(bankAccount);

		        while (true) {
		            System.out.println("\nATM Interface");
		            System.out.println("1. Deposit");
		            System.out.println("2. Withdraw");
		            System.out.println("3. Check Balance");
		            System.out.println("4. Exit");
		            System.out.print("Choose an option (1-4): ");

		            int choice = scanner.nextInt();
		            double amount;

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter deposit amount: $");
		                    amount = scanner.nextDouble();
		                    atm.deposit(amount);
		                    break;

		                case 2:
		                    System.out.print("Enter withdrawal amount: $");
		                    amount = scanner.nextDouble();
		                    atm.withdraw(amount);
		                    break;

		                case 3:
		                    atm.checkBalance();
		                    break;

		                case 4:
		                    System.out.println("Exiting the ATM Interface. Have a great day!");
		                    scanner.close();
		                    System.exit(0);

		                default:
		                    System.out.println("Invalid option. Please choose again.");
		            }
		        }

	}

}
