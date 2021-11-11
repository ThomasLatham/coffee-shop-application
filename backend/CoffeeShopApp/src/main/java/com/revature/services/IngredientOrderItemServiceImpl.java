package com.revature.services;

import com.revature.models.IngredientOrderItem;
import com.revature.repositories.IngredientOrderItemRepo;
import com.revature.repositories.OrderItemRepo;
import com.revature.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientOrderItemServiceImpl implements IngredientOrderItemService {

    @Autowired
    IngredientOrderItemRepo ioir;

    @Autowired
    OrderItemRepo oir;

    @Autowired
    OrderRepo or;

    @Override
    public IngredientOrderItem addIngredientOrderItem(IngredientOrderItem actor) {
        return ioir.save(actor);
    }

    @Override
    public IngredientOrderItem getIngredientOrderItem(int id) {
        return ioir.findById(id).get();
    }

    @Override
    public List<IngredientOrderItem> getAllIngredientOrderItems() {
        return (List<IngredientOrderItem>) ioir.findAll();
    }

    @Override
    public IngredientOrderItem updateIngredientOrderItem(IngredientOrderItem newData) {
        return ioir.save(newData);
    }

    @Override
    public List<List<IngredientOrderItem>> submitOrder(List<List<IngredientOrderItem>> cart) {

        //put the order in the DB
        //put the orderItems in the DB
        //put the ingredientOrderItems in the DB
        return cart;
    }

}
