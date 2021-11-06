import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { MenuItem } from "src/app/models/MenuItem";
import { MenuItemIngredient } from "src/app/models/MenuItemIngredient";
import {Order} from "src/app/models/Order";
import {User} from "src/app/models/User";
import { OrderStatus } from 'src/app/models/OrderStatus';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  baseurl1 = 'http://localhost:3000/cart/';
  baseurl2 = 'http://localhost:3000/cart/ingredient';
  baseurl3 = 'http://localhost:3000/cart/order';
  baseurl4 = 'http://localhost:3000/cart/user';
  baseurl5 = 'http://localhost:3000/cart/OrderStatuses';
  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  GetItem(id): Observable<MenuItem> {
    return this.http.get<MenuItem>(this.baseurl1 + id)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


  GetIngredient(id): Observable<MenuItemIngredient> {
    return this.http.get<MenuItemIngredient>(this.baseurl2 + id)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


  Getorder(id): Observable<Order> {
    return this.http.get<Order>(this.baseurl3 + id)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


  Getuser(id): Observable<User> {
    return this.http.get<User>(this.baseurl4 + id)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


  Getstatus(id): Observable<OrderStatus> {
    return this.http.get<OrderStatus>(this.baseurl5 + id)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


  GetItems(): Observable<MenuItem> {
    return this.http.get<MenuItem>(this.baseurl1)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }



  GetIngredients(): Observable<MenuItemIngredient> {
    return this.http.get<MenuItemIngredient>(this.baseurl2)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }





  // DELETE
  DeleteItem(id){
    return this.http.delete<MenuItem>(this.baseurl1 + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


  DeleteIngedient(id){
    return this.http.delete<MenuItemIngredient>(this.baseurl2 + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }



  DeleteOrder(id){
    return this.http.delete<Order>(this.baseurl3 + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }



  AddQuantity(id){
    return this.http.get<Order>(this.baseurl3 + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


  RemoveQuantity(id){
    return this.http.delete<Order>(this.baseurl3 + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }



  // Error handling
  errorHandl(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }





}
