package com.revature.controllers;

import com.revature.models.Order;
import com.revature.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService os;

    @GetMapping("/order")
    public List<Order> getAllOrders(){
        return os.getAllOrders();
    }
    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") int id){
        return os.getOrder(id);
    }
    @PostMapping(value = "/order", consumes = {"application/json"}, produces = "application/json")
    public Order addOrder(@RequestBody Order o){
        return os.addOrder(o);
    }
    @PutMapping(value = "/order/{id}", consumes = {"application/json"}, produces = "application/json")
    public Order updateOrder(@PathVariable("id") String id, @RequestBody Order change) {
        return os.updateOrder(change);
    }
    @DeleteMapping(value = "/order/{id}")
    public boolean deleteOrder(@PathVariable String id) {
        int deleteId = -1;
        try{
           deleteId = Integer.parseInt(id);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }
        return os.deleteActor(deleteId);
    }


}
