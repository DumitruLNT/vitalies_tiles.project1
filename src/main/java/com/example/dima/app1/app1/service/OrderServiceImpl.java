package com.example.dima.app1.app1.service;

import com.example.dima.app1.app1.dto.OrderDto;
import com.example.dima.app1.app1.model.Order;
import com.example.dima.app1.app1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((order) -> mapToOrderDto(order)).collect(Collectors.toList());
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderDto findById(long orderId) {
        Order order = orderRepository.findById(orderId).get();
        return mapToOrderDto(order);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        orderRepository.save(mapToOrder(orderDto));
    }

    public OrderDto mapToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .price(order.getPrice())
                .name(order.getName())
                .orderPhotoUrl(order.getOrderPhotoUrl())
                .build();
    }

    private Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .name(orderDto.getName())
                .price(orderDto.getPrice())
                .orderPhotoUrl(orderDto.getOrderPhotoUrl())
                .build();
    }
}
