import java.util.Arrays;


class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

class BinarySearch {
    public static int binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return mid;
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }
}

public class ECommercePlatformSearch_Binary {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Smartphone", "Electronics"),
            new Product(103, "Desk", "Furniture"),
            new Product(104, "Chair", "Furniture"),
            new Product(105, "Blender", "Home Appliances")
        };

        
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.productId, p2.productId));

        int targetId = 103;
        int index = BinarySearch.binarySearch(products, targetId);

        if (index != -1) {
            System.out.println("Product found: " + products[index]);
        } else {
            System.out.println("Product with ID " + targetId + " not found.");
        }
    }
}