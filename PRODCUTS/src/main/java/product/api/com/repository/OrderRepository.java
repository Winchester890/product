package product.api.com.repository;

import org.springframework.stereotype.Repository;
import product.api.com.entities.Order;

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
}
