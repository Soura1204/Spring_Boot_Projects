class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    
    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommercePlatformSearch_Linear {

    
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Tablet", "Electronics"),
            new Product(3, "Smartphone", "Electronics"),
            new Product(4, "Headphones", "Accessories"),
            new Product(5, "Smartwatch", "Accessories")
        };

        int searchId = 3; 
        Product foundProduct = linearSearch(products, searchId);

        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product with ID " + searchId + " not found.");
        }
    }
}