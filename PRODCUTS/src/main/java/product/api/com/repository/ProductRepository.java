package product.api.com.repository;
import org.springframework.stereotype.Repository;
import product.api.com.entities.Order;
import product.api.com.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> productList = new ArrayList<>();
    public void listAllProducts() {
        if (productList != null) {
            for (Product product : productList) {
                System.out.println("Name: " + product.getName());
                System.out.println("ID: " + product.getId());
                System.out.println("Current quantity: " + product.getQuantity());
                System.out.println("Price: " + product.getPrice());
            }
        } else {
            System.out.println("No products registered so far!");
        }
    }

    public Integer add(final Product product) {
        if (product.getId() == null) {
            product.setId(productList.size() + 1);
        }
        productList.add(product);
        return product.getId();
    }
    public Double sell(Order order) {
        
    }
}

