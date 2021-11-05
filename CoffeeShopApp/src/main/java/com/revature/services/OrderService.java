package com.revature.services;

import com.revature.models.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    public Order addOrder(Order o);
    public List<Order> getAllOrders();
    public Order getOrder(int id);
    public Order updateOrder(Order change);
    public boolean deleteActor(int id);
}
