package pl.asia.infrastructure.db.order;

import pl.asia.infrastructure.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryInMemory implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    private long id = 1;


    @Override
    public Order saveOrder(Order order) {
        orders.add(new Order(id++, order.getProductName(), order.getQuantity(), order.getPrice()));
        return order;
    }

    @Override
    public List<Order> getOrders() {return orders;}

    @Override
    public Order getOrder(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findAny()
                .orElseThrow(() ->{throw new RuntimeException("Zamówienie o podanym id nie istnieje");});
    }

    @Override
    public void removeOrder(Long id) {
        Order order = getOrder(id);
        orders.remove(order);

    }

    @Override
    public void updateOrder(Order order) {
        removeOrder(order.getId());
        orders.add(order);

    }


}
