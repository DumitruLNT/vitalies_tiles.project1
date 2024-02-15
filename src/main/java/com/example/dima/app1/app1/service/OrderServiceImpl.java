package com.example.dima.app1.app1.service;

import com.example.dima.app1.app1.model.Order;
import com.example.dima.app1.app1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findOrderById(long orderId) {
        Order order = orderRepository.findById(orderId).get();
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order deleteOrderById(Long id) {
        orderRepository.deleteById(id);
        return null;
    }
}
