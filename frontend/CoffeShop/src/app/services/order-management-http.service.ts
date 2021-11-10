import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../models/Order';
import { Observable } from 'rxjs';
import { OrderItem } from '../models/OrderItem';

@Injectable({
  providedIn: 'root'
})
export class OrderManagementHttpService {

  constructor(private http: HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getOrdersToday(): Observable<Order[]>{
    let today = new Date();
    let day = new Date( today.getFullYear(), today.getMonth(), today.getDate());
    let dayms = day.getTime();
    return this.http.get<Order[]>('http://localhost:8080/orders/day/' + dayms);
  }

  getOrdersDay(day: number): Observable<Order[]>{
    return this.http.get<Order[]>('http://localhost:8080/orders/day/' + day);
  }

  getOrderItems(): Observable<OrderItem[]>{
    let today = new Date();
    let day = new Date( today.getFullYear(), today.getMonth(), today.getDate());
    let todayString = day.getFullYear() + '-' + day.getMonth() + "-" + day.getDate();
    return this.http.get<OrderItem[]>('http://localhost:8080/orderItems/today/'+todayString);
  }

  advanceOrder(order: Order): Observable<Order> {
    console.log(order);
    let url = 'http://localhost:8080/orders/advance/' + order.orderID;
    console.log(url);
    return this.http.put<Order>(url, JSON.stringify(order), this.httpOptions);
  }
}
