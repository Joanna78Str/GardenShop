package pl.asia.infrastructure.db.order;

import pl.asia.infrastructure.entity.Order;

import java.util.List;

public interface OrderRepository {

    Order saveOrder(Order order);

    List<Order>getOrders();

    Order getOrder(Long id);

    void removeOrder(Long id);

    void updateOrder(Order order);
}
