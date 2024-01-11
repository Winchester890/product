package product.api.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.api.com.entities.Order;
import product.api.com.entities.Product;
import product.api.com.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity addOrder(@RequestBody final Order order) {
        orderService.addOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity sell(@RequestBody final Order order, final Product product,
                               Integer quantity, Double discount) {
        orderService.sell(order, product, quantity, discount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
