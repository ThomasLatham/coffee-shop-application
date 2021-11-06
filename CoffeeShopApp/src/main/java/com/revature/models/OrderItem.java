package com.revature.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderID;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private MenuItem itemID;

    @Column(name = "item_count")
    private int  itemCount;

    public OrderItem() {
    }

    public OrderItem(int id, Order orderID, MenuItem itemID, int itemCount) {
        this.id = id;
        this.orderID = orderID;
        this.itemID = itemID;
        this.itemCount = itemCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public MenuItem getItemID() {
        return itemID;
    }

    public void setItemID(MenuItem itemID) {
        this.itemID = itemID;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return getId() == orderItem.getId() && getItemCount() == orderItem.getItemCount() && Objects.equals(getOrderID(), orderItem.getOrderID()) && Objects.equals(getItemID(), orderItem.getItemID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderID(), getItemID(), getItemCount());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderID=" + orderID +
                ", itemID=" + itemID +
                ", itemCount=" + itemCount +
                '}';
    }
}
