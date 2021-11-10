import { Component, OnInit } from '@angular/core';
import { Order } from '../../models/Order';
import { OrderItem } from '../../models/OrderItem';
import { OrderManagementHttpService } from '../../services/order-management-http.service';

@Component({
  selector: 'app-order-management',
  templateUrl: './order-management.component.html',
  styleUrls: ['./order-management.component.css']
})
export class OrderManagementComponent implements OnInit {

  constructor(private orderHttp: OrderManagementHttpService) { }

  ngOnInit(): void {
    this.getOrderToday();
    this.getOrderItems();
  }

  orderByDayList: Order[];
  orderList: Order[]; 
  orderItemsList: OrderItem[];
  day: Date;
  buttonDisplay: string = "";
  // get all orders then for each order, getOrderItems

  advanceOrder(order: Order): void{
    this.orderHttp.advanceOrder(order).subscribe(
      (response) =>{
        if(order.delivery==true && order.orderStatus.status=="Ready"){
          this.buttonDisplay = "Order is Complete";
        }
        if(order.orderStatus.status == "Ready" && !order.delivery==true) {
          this.buttonDisplay = "Order is Complete";
        }
        if(order.orderStatus.status == 'Order Received'){
          this.buttonDisplay = "Order is being Delivered";
        }
        console.log(response);
        window.location.reload();
      }
    );
  }
  
  isDelivery(order: Order): boolean {
    if(order.delivery==true && order.orderStatus.status=="Ready") {
      this.buttonDisplay = "Order is picked up by deliveryman and is being Delivered";
      return true;
    }
    return false;
  }

  statusReady(order: Order): boolean{
    if(order.orderStatus.status == "Ready" && !order.delivery==true){
      this.buttonDisplay = "Order is Complete";
      return true;
    }
    return false;
  }

  statusReceived(order: Order): boolean {
    if(order.orderStatus.status == 'Order Received'){
      this.buttonDisplay = "Order is ready";
      return true;
    }
    return false;
  }

  getOrderToday(): void{
    this.orderHttp.getOrdersToday().subscribe(
      (response) => {
        console.log(response);
        this.orderList = response;
      }
    );
  }
  getOrderDay(): void {
    console.log(this.day);
    let realday = new Date(this.day)
    let dayms = realday.getTime();
    this.orderHttp.getOrdersDay(dayms).subscribe(
      (response) => {
        this.orderByDayList = response;
      }
    )

  }
  getOrderItems(): void{
    this.orderHttp.getOrderItems().subscribe(
      (response) => {
        this.orderItemsList = response;
      }
    )
  }

}
