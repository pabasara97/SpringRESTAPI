/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serrvice;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> saveOrders(List<Order> orders) {
        return repository.saveAll(orders);
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order getOrderById(long id) {
        return repository.findById(id).orElse(null);
    }

   
    public String deleteOrder(long id) {
        repository.deleteById(id);
        return "order removed !! " + id;
    }

    public Order updateOrder(Order order) {
        Order existingOrder = repository.findById(order.getId()).orElse(null);
        existingOrder.setUser(order.getUser());
        existingOrder.setItem(order.getItem());
        existingOrder.setQty(order.getQty());
        return repository.save(existingOrder);
    }


}
