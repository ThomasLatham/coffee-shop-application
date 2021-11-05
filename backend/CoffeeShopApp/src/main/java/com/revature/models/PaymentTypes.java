package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "payment_types")
public class PaymentTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id")
    private int paymentTypeId;
    @Column(name = "payment_type_name")
    private String paymentTypeName;

    public PaymentTypes() {
    }

    public PaymentTypes(int paymentTypeId, String paymentTypeName) {
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentTypes)) return false;
        PaymentTypes that = (PaymentTypes) o;
        return getPaymentTypeId() == that.getPaymentTypeId() && Objects.equals(getPaymentTypeName(), that.getPaymentTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentTypeId(), getPaymentTypeName());
    }

    @Override
    public String toString() {
        return "PaymentTypes{" +
                "paymentTypeId=" + paymentTypeId +
                ", paymentTypeName='" + paymentTypeName + '\'' +
                '}';
    }
}
