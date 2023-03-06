package pl.asia.domain.service;

import pl.asia.infrastructure.db.order.OrderRepository;
import pl.asia.infrastructure.entity.Order;

import java.util.List;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(String productName, int quantity, double price){
        return orderRepository.saveOrder(new Order(productName,quantity,price));
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }
    public Order getOrder(Long id){return orderRepository.getOrder(id);}

    public void removeOrder(Long id) {
        orderRepository.removeOrder(id);
    }

    public void updateOrder(int quantity, double price,Long id){
        Order orderFromDB = orderRepository.getOrder(id);
        Order orderToUpdate = new Order(
                orderFromDB.getId(),
                orderFromDB.getProductName(),
                quantity,price
        );
        orderRepository.updateOrder(orderToUpdate);
    }

}
