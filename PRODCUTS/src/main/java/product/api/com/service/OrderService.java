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

    public Double sell(Product product, Integer quantity, Double discount) {
        Order order = new Order();
        order.setId(orderRepository.getOrderList().size() + 1);
        order.setProduct(product);
        order.setDiscount(discount);
        order.setQuantity(quantity);
        if (order.getDiscount() > order.getProduct().getMaxDiscount()) {
            order.setDiscount(order.getProduct().getMaxDiscount());
        }
        orderRepository.addOrder(order);
        return order.getOrderPrice();
    }
}
