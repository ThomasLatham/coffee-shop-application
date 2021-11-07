package com.revature.services;

import com.revature.models.Order;
import com.revature.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepo or;

    @Override
    public Order addOrder(Order o) {
        return or.save(o);
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) or.findAll();
    }

    @Override
    public Order getOrder(int id) {
        return or.findById(id).get();
    }

    @Override
    public Order updateOrder(Order change) {
        return or.save(change);
    }

    @Override
    public boolean deleteActor(int id) {
        try{
            or.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }
}
