import java.util.ArrayList;
import java.util.List;

class OrderManagement {

    int id;
    double price;
    String status;

    public OrderManagement(int id, double price, String status) {
        this.id = id;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}

public class OrderService {

    public static List<OrderManagement> filterUrgentOrders(List<OrderManagement> Order, double priceThreshold) {
        ArrayList<OrderManagement> result = new ArrayList<>();

        for (OrderManagement o : Order) {
            if (o.getPrice() > priceThreshold && o.getStatus().equals("Pending")) {
                result.add(o);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        ArrayList<OrderManagement> order = new ArrayList<>();
        order.add(new OrderManagement(101, 200, "Pending"));
        order.add(new OrderManagement(102, 50, "Pending"));
        order.add(new OrderManagement(103, 500, "Shipped"));
        order.add(new OrderManagement(104, 700, "Pending"));

        List<OrderManagement> resultValue = filterUrgentOrders(order, 200.0);
        System.out.println("Orders which are Urgent: ");
        for (OrderManagement o : resultValue) {
            System.out.println(
                    "Order ID: " + o.getId() + " Order Price: " + o.getPrice() + " Order Status: " + o.getStatus());
        }

    }
}