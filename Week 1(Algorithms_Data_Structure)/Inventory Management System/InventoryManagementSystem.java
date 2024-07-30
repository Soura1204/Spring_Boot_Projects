import java.util.ArrayList;
import java.util.List;
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public int getProductId() 
	{ 
		return productId; 
	}
    public void setProductId(int productId) 
	{ 
		this.productId = productId; 
	}

    public String getProductName() 
	{ 
		return productName; 
	}
    public void setProductName(String productName) 
	{ 
		this.productName = productName; 
	}

    public int getQuantity() 
	{ 
		return quantity; 
	}
    public void setQuantity(int quantity) 
	{ 
		this.quantity = quantity; 
	}

    public double getPrice() 
	{ 	
		return price; 
	}
    public void setPrice(double price) 
	{ 
		this.price = price; 
	}

    public String toString() 
	{
        return "Product [productId=" + productId + ", productName=" + productName +
                ", quantity=" + quantity + ", price=" + price + "]";
    }
}
class Inventory 
{
     List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int productId, String productName, int quantity, double price) {
        for (Product product : products) 
		{
            if (product.getProductId() == productId) {
                product.setProductName(productName);
                product.setQuantity(quantity);
                product.setPrice(price);
                break;
            }
        }
    }

    public void deleteProduct(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
public class InventoryManagementSystem 
{
    public static void main(String[] args) 
	{
        Inventory inventory = new Inventory();

        
        inventory.addProduct(new Product(1, "Coffee", 10, 1000.00));
        inventory.addProduct(new Product(2, "Pizza", 50, 15000.32));
        inventory.addProduct(new Product(3, "Burger", 20, 4000.21));

        
        System.out.println("Products in inventory:");
        inventory.listProducts();

        
        inventory.updateProduct(2, "Cheese Cake", 45, 6000.32);
        System.out.println("\nAfter updating product 2:");
        inventory.listProducts();

        
        inventory.deleteProduct(1);
        System.out.println("\nAfter deleting product 1:");
        inventory.listProducts();
    }
}