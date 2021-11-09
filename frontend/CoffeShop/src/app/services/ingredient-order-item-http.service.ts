import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { IngredientOrderItem } from '../models/IngredientOrderItem';

@Injectable({providedIn: 'root'})
export class IngredientOrderItemHttpService {
  // Base url
  baseurl = 'http://localhost:8080/ingredientOrderItems/';
  
  constructor(private http: HttpClient) { }
  
  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  
  // POST
  CreateIngredientOrderItem(data): Observable<IngredientOrderItem> {
    return this.http.post<IngredientOrderItem>(this.baseurl , JSON.stringify(data), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }  
  
  // GET
  GetIngredientOrderItem(id): Observable<IngredientOrderItem> {
    return this.http.get<IngredientOrderItem>(this.baseurl + id)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }
  
  // GET
  GetIngredientOrderItems(): Observable<IngredientOrderItem> {
    return this.http.get<IngredientOrderItem>(this.baseurl)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }
  
  // PUT
  UpdateIngredientOrderItem(id, data): Observable<IngredientOrderItem> {
    return this.http.put<IngredientOrderItem>(this.baseurl + id, JSON.stringify(data), this.httpOptions)
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