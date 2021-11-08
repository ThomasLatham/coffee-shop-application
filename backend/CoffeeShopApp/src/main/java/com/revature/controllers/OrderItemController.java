package com.revature.controllers;

import com.revature.models.OrderItem;
import com.revature.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    OrderItemService ois;


    @GetMapping("/orderItems")
    public List<OrderItem> getAllOrderItems(){
        return ois.getAllOrderItems();
    }


    @GetMapping("/orderItems/{id}")
    public OrderItem getOrder(@PathVariable("id") int id){
        return ois.getOrderItem(id);
    }


    @PostMapping(value = "/orderItems", consumes = {"application/json"}, produces = "application/json")
    public OrderItem addOrderItem(@RequestBody OrderItem oi){
        return ois.addOrderItem(oi);
    }


    @PutMapping(value = "/orderItems/{id}", consumes = {"application/json"}, produces = "application/json")
    public OrderItem updateOrderItem(@PathVariable("id") String id, @RequestBody OrderItem change) {
        return ois.updateOrderItem(change);
    }


    @DeleteMapping(value = "/orderItems/{id}")
    public boolean deleteOrderItem(@PathVariable String id) {
        int deleteId = -1;
        try{
            deleteId = Integer.parseInt(id);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }
        return ois.deleteOrderItem(deleteId);
    }
}