package com.example.dima.app1.app1.controller;

import com.example.dima.app1.app1.model.Order;
import com.example.dima.app1.app1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order newOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order existingOrder = orderService.findOrderById(id);

        if(existingOrder == null) {
            addOrder(updatedOrder);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        existingOrder.setName(updatedOrder.getName());
        existingOrder.setPrice(updatedOrder.getPrice());
        existingOrder.setOrderPhotoUrl(updatedOrder.getOrderPhotoUrl());

        updatedOrder = orderService.updateOrder(existingOrder);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
