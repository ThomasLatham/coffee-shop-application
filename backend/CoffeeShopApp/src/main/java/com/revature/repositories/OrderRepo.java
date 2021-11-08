package com.revature.repositories;

import com.revature.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT * FROM orders WHERE order_time >= :dayStart AND order_time <= dayEnd", nativeQuery = true)
    public List<Order> getOrdersByDay(@Param("dayStart") Long dayStart, @Param("dayEnd") Long dayEnd);
}
