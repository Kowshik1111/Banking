import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager databaseManager = new DatabaseManager();

        while (true) {
            System.out.println("Banking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Transfer Funds");
            System.out.println("3. View Account Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createAccount(scanner, databaseManager);
                    break;
                case 2:
                    transferFunds(scanner, databaseManager);
                    break;
                case 3:
                    viewAccountInformation(scanner, databaseManager);
                    break;
                case 4:
                    System.out.println("Exiting Banking System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void createAccount(Scanner scanner, DatabaseManager databaseManager) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        Account newAccount = new Account(accountNumber, accountType, initialBalance);
        databaseManager.addAccount(newAccount);

        System.out.println("Account created successfully!");
    }

    private static void transferFunds(Scanner scanner, DatabaseManager databaseManager) {
        System.out.print("Enter source account number: ");
        String sourceAccountNumber = scanner.nextLine();

        Account sourceAccount = databaseManager.getAccountByNumber(sourceAccountNumber);

        if (sourceAccount != null) {
            System.out.print("Enter destination account number: ");
            String destinationAccountNumber = scanner.nextLine();

            Account destinationAccount = databaseManager.getAccountByNumber(destinationAccountNumber);

            if (destinationAccount != null) {
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                if (sourceAccount.transferFunds(destinationAccount, amount)) {
                    databaseManager.addTransaction(new Transaction("Transfer", amount));
                    System.out.println("Funds transferred successfully!");
                } else {
                    System.out.println("Transfer failed. Check your account balance.");
                }
            } else {
                System.out.println("Destination account not found.");
            }
        } else {
            System.out.println("Source account not found.");
        }
    }

    private static void viewAccountInformation(Scanner scanner, DatabaseManager databaseManager) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = databaseManager.getAccountByNumber(accountNumber);

        if (account != null) {
            System.out.println("Account Information:");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
