import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String date;
    private String type;
    private double amount;

    // Constructors
    public Transaction(String type, double amount) {
        this.date = getCurrentDateTime();
        this.type = type;
        this.amount = amount;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    // Method to get current date and time in a formatted string
    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
