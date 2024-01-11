package product.api.com.entities;


import org.junit.jupiter.api.Test;
import product.api.com.repository.OrderRepository;


import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void shouldCalculateTotalPriceWithDiscount() {
        OrderRepository orderRepository = new OrderRepository();
        Order order = new Order();
        Product product = new Product(1, "TESTE", 10, 10.0, 0.10);
        Double result = orderRepository.sell(order, product, 5, 0.10);
        assertEquals(45.0, result);
    }
}
