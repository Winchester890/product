package product.api.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.api.com.entities.Product;
import product.api.com.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void listAllProducts() {
        productRepository.listAllProducts();
    }

    public Integer addProduct(final Product product) {
        if (product.getId() == null) {
            product.setId(productRepository.count() + 1);
        }
        productRepository.addProduct(product);
        return product.getId();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public void update(final Product product) {
        productRepository.update(product);
    }

    public void delete(Integer id) {
        productRepository.delete(id);
    }
}
