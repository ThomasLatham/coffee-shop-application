package com.revature.controllers;

import com.revature.models.Order;
import com.revature.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService os;

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return os.getAllOrders();
    }
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable("id") int id){
        return os.getOrder(id);
    }
    @PostMapping(value = "/orders", consumes = {"application/json"}, produces = "application/json")
    public Order addOrder(@RequestBody Order o){
        return os.addOrder(o);
    }
    @PutMapping(value = "/orders/{id}", consumes = {"application/json"}, produces = "application/json")
    public Order updateOrder(@PathVariable("id") String id, @RequestBody Order change) {
        return os.updateOrder(change);
    }
    @DeleteMapping(value = "/orders/{id}")
    public boolean deleteOrder(@PathVariable String id) {
        int deleteId = -1;
        try{
           deleteId = Integer.parseInt(id);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }
        return os.deleteOrder(deleteId);
    }
    @GetMapping("/orders/day/{day}")
    public List<Order> getOrdersByDay(@PathVariable String day){
        List<Order> dayOrders = null;
        long realDay = 0L;
        try{
            realDay = Long.parseLong(day);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return dayOrders;
        }
        return os.getOrdersByDay(realDay);
    }
    @PutMapping(value = "/orders/advance/{id}", consumes = {"application/json"}, produces = "application/json")
    public Order advanceOrder(@PathVariable("id") String id, @RequestBody Order change) {
        try{
            change.setorderID(Integer.parseInt(id));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return os.advanceOrder(change);
    }


}
