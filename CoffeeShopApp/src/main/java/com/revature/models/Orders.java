package com.revature.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "orderTime")
    private long orderTime;

    @ManyToOne
    @JoinColumn(name = "order_status")
    private OrderStatuses orderStatus;

    @ManyToOne
    @JoinColumn(name = "ordered_by")
    private Users orderedBy;

    @ManyToOne
    @JoinColumn(name = "order_payment")
    private PaymentTypes orderPayment;

    @Column(name = "delivery")
    private Boolean delivery;

    public Orders() {
    }

    public Orders(int orderId, long orderTime, OrderStatuses orderStatus, Users orderedBy, PaymentTypes orderPayment, Boolean delivery) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.orderedBy = orderedBy;
        this.orderPayment = orderPayment;
        this.delivery = delivery;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public OrderStatuses getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatuses orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Users getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Users orderedBy) {
        this.orderedBy = orderedBy;
    }

    public PaymentTypes getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(PaymentTypes orderPayment) {
        this.orderPayment = orderPayment;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return getOrderId() == orders.getOrderId() && getOrderTime() == orders.getOrderTime() && Objects.equals(getOrderStatus(), orders.getOrderStatus()) && Objects.equals(getOrderedBy(), orders.getOrderedBy()) && Objects.equals(getOrderPayment(), orders.getOrderPayment()) && Objects.equals(getDelivery(), orders.getDelivery());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getOrderTime(), getOrderStatus(), getOrderedBy(), getOrderPayment(), getDelivery());
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderTime=" + orderTime +
                ", orderStatus=" + orderStatus +
                ", orderedBy=" + orderedBy +
                ", orderPayment=" + orderPayment +
                ", delivery=" + delivery +
                '}';
    }
}
