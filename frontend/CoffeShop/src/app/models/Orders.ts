import { OrderStatuses } from "./OrderStatuses";
import { PaymentTypes } from "./paymentTypes";
import { User } from "./User";

export class Orders {
    orderId: number;
    orderTime: bigint;
    orderStatus: OrderStatuses;
    orderedBy: User;
    orderPayment: PaymentTypes;
    delivery: boolean;

    constructor(orderId: number, orderTime: bigint, orderStatus: OrderStatuses, orderedBy: User, orderPayment: PaymentTypes, delivery: boolean){

        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.orderedBy = orderedBy;
        this.orderPayment = orderPayment;
        this.delivery = delivery;

    }
}

