package product.api.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.api.com.entities.Product;
import product.api.com.repository.OrderRepository;
import product.api.com.entities.Order;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(final Order order) {
        orderRepository.addOrder(order);
    }
    public Double sell(Order order, Product product, Integer quantity, Double discount) {
        return orderRepository.sell(order, product, quantity, discount);
    }

}
