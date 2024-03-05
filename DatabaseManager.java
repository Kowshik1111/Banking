import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private List<Account> accounts;
    private List<Transaction> transactions;

    // Constructor
    public DatabaseManager() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Methods for interacting with the database

    // Method to add an account to the database
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to retrieve all accounts from the database
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    // Method to find an account by account number
    public Account getAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Account not found
    }

    // Method to add a transaction to the database
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Method to retrieve all transactions from the database
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
