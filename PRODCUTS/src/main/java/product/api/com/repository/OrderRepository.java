package product.api.com.repository;

import org.springframework.stereotype.Repository;
import product.api.com.entities.Order;
import product.api.com.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(final Order order) {
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public Double sell(Order order, Product product, Integer quantity, Double discount) {
        order.setId(getOrderList().size() + 1);
        order.setProduct(product);
        if (product.getQuantity() < quantity) {
            quantity = product.getQuantity();
        }
        order.setQuantity(quantity);
        product.setQuantity(product.getQuantity() - quantity);
        if (discount > product.getMaxDiscount()) {
            order.setDiscount(product.getMaxDiscount());
        } else {
            order.setDiscount(discount);
        }
        Double price = order.getOrderPrice() - (order.getOrderPrice()) * order.getDiscount();
        return price;
    }
}
