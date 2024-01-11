package product.api.com.repository;
import org.springframework.stereotype.Repository;
import product.api.com.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Integer addProduct(final Product product) {
        if (product.getId() == null) {
            product.setId(productList.size() + 1);
        }
        productList.add(product);
        return product.getId();
    }

    public Product findById(Integer id) throws RuntimeException {
        return productList.stream().
                filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    public void update(final Product product) {
        productList.stream()
                .filter(product1 -> product1.getId().equals(product.getId()))
                .forEach(product1 -> product1.setName(product.getName()));
        productList.stream()
                .filter(product1 -> product1.getId().equals(product.getId()))
                .forEach(product1 -> product1.setQuantity(product.getQuantity()));
        productList.stream()
                .filter(product1 -> product1.getId().equals(product.getId()))
                .forEach(product1 -> product1.setPrice(product.getPrice()));
        productList.stream()
                .filter(product1 -> product1.getId().equals(product.getId()))
                .forEach(product1 -> product1.setMaxDiscount(product.getMaxDiscount()));
    }

    public void delete(Integer id) {
        productList.removeIf(product1 -> product1.getId().equals(id));
    }

    public int count() {
        return productList.size();
    }
}
