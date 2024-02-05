package com.example.dima.app1.app1.service;

import com.example.dima.app1.app1.dto.OrderDto;
import com.example.dima.app1.app1.model.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders();
    Order saveOrder(Order order);

    OrderDto findById(long orderId);

    void updateOrder(OrderDto order);
}
