import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
}

public class InventoryService {

    public static List<Product> applyDiscount(List<Product> products, String targetCategory) {
        for (Product p : products) {
            if (p.getCategory().equals(targetCategory) && p.getPrice() > 100.0) {
                p.setPrice(p.getPrice() * 0.9);
            }
        }

        return products;

    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Jeans", 120.0, "Clothing"));
        products.add(new Product("T-Shirt", 20.0, "Clothing"));
        products.add(new Product("Laptop", 1200.0, "Electronics"));

        List<Product> resultingList = applyDiscount(products, "Clothing");
        for (Product p : resultingList) {
            System.out
                    .println("Name: " + p.getName() + " | Price: " + p.getPrice() + " | Category: " + p.getCategory());
        }

    }
}