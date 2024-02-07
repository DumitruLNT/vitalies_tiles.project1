package com.example.dima.app1.app1.controller;

import com.example.dima.app1.app1.dto.OrderDto;
import com.example.dima.app1.app1.model.Order;
import com.example.dima.app1.app1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String listOfOrders(Model model){
        List<OrderDto> orders = orderService.findAllOrders();
        model.addAttribute("orders", orders);
        return "orders-list";
    }

    @GetMapping("/orders/new")
    public String createOrders(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "order-create";
    }

    @PostMapping("/orders/new")
    public String saveOrders(@ModelAttribute("order") Order order){
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

//    @GetMapping("/orders/{id}/edit")
//    public String editOrders(@PathVariable("id") long orderId, Model model){
//        OrderDto orderDto = orderService.findById(orderId);
//        model.addAttribute("orderDto", orderDto);
//        return "orders-edit";
//    }
//
//    @PostMapping("orders/{id}/edit")
//    public String editOrders(@PathVariable("id") long orderId, @ModelAttribute("order") OrderDto order){
//        order.setId(orderId);
//        orderService.updateOrder(order);
//        return "redirect:/orders";
//    }
}
