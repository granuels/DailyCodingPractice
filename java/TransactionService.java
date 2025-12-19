import java.util.ArrayList;
import java.util.List;

class Transaction {

    int id;
    double amount;
    String category;

    public Transaction(int id, double amount, String category) {
        this.id = id;
        this.amount = amount;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

}

public class TransactionService {

    public static List<Transaction> filterHighValue(List<Transaction> transactions, double limit) {
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() > limit) {
                result.add(t);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 500.0, "Electronics"));
        transactions.add(new Transaction(2, 2300.0, "Skincare"));
        transactions.add(new Transaction(3, 2600.0, "Jewellery"));
        transactions.add(new Transaction(4, 3000.0, "Furniture"));
        transactions.add(new Transaction(5, 200.0, "Groceries"));

        List<Transaction> highValue = filterHighValue(transactions, 2500);
        System.out.println("Number of High value transactions: " + highValue.size());
        for (Transaction t : highValue) {
            System.out.println("ID: " + t.getId() + " | Amount: " + t.getAmount());
        }

    }
}