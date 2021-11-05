import {Orders} from "./Orders"
import {MenuItem} from "./MenuItem"


export class OrderItem {

    orderItemID: number;
    order: Orders;
    menuItem: MenuItem;
    itemCount: number;


  constructor(
    orderItemID: number, 
    order: Orders, 
    menuItem: MenuItem, 
    itemCount: number
) {
    this.orderItemID = orderItemID
    this.order = order
    this.menuItem = menuItem
    this.itemCount = itemCount
  }


}