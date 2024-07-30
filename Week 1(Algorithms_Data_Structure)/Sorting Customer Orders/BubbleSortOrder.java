class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    
    public void displayOrder() {
        System.out.println("Order ID: " + orderId + ", Customer Name: " + customerName + ", Total Price: $" + totalPrice);
    }
}

public class BubbleSortOrder {
    
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        
        Order[] orders = {
            new Order(1, "Sourajit", 600.0),
            new Order(2, "Sayak", 863.0),
            new Order(3, "Messi", 356.0),
            new Order(4, "Tanmay", 789.0)
        };

        
        System.out.println("Orders before sorting:");
        for (Order order : orders) {
            order.displayOrder();
        }

        
        bubbleSort(orders);

        
        System.out.println("\nOrders after sorting by total price:");
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}
