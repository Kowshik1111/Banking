public class Account {
    private String accountNumber;
    private String accountType;
    private double balance;

    // Constructors
    public Account(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method for transferring funds
    public boolean transferFunds(Account destinationAccount, double amount) {
        if (amount > 0 && balance >= amount) {
            // Deduct amount from source account
            this.balance -= amount;

            // Add amount to destination account
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);

            // Transaction successful
            return true;
        } else {
            // Insufficient funds or invalid amount
            return false;
        }
    }
}
