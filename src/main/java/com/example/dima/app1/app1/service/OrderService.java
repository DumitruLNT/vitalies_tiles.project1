package com.example.dima.app1.app1.service;

import com.example.dima.app1.app1.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Order saveOrder(Order order);

    Order findOrderById(long orderId);

    Order updateOrder(Order order);

    Order deleteOrderById(Long id);
}
