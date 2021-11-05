package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "order_statuses")
public class OrderStatuses {
    @Id
    @Column(name = "status_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int statusId;
    @Column(name = "status")
    private String status;

    public OrderStatuses() {
    }

    public OrderStatuses(int statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderStatuses)) return false;
        OrderStatuses that = (OrderStatuses) o;
        return getStatusId() == that.getStatusId() && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusId(), getStatus());
    }

    @Override
    public String toString() {
        return "OrderStatuses{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }
}
