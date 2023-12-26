package product.api.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.api.com.entities.Product;
import product.api.com.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    @Autowired
    private ProductService productService;

    @GetMapping("/listAll")
    public ResponseEntity listAllProducts() {
        productService.listAllProducts();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Product findById(@PathVariable("id") Integer id) {
        try {
            productList = (List<Product>) productService.findById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return (Product) productList;
    }

    @PostMapping
    public ResponseEntity<Integer> addProduct(@RequestBody final Product product) {
        Integer id = productService.addProduct(product);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Product product) {
        productService.update(product);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
