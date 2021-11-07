package com.revature.repositories;


import com.revature.models.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends CrudRepository<OrderItem, Integer> {
}
