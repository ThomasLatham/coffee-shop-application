package com.revature.services;

import com.revature.models.Order;
import com.revature.models.OrderItem;
import com.revature.repositories.OrderItemRepo;
import com.revature.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    OrderItemRepo oi;

    @Override
    public OrderItem addOrderItem(OrderItem o) {
        return oi.save(o);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return (List<OrderItem>) oi.findAll();
    }

    @Override
    public OrderItem getOrderItem(int id) {
        return oi.findById(id).get();
    }

    @Override
    public OrderItem updateOrderItem(OrderItem change) {
        return oi.save(change);
    }

    @Override
    public boolean deleteOrderItem(int id) {
        try{
            oi.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }
}
