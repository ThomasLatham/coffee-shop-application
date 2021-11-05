import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Movie } from '../models/Items';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ItemsHttpService {

  constructor(private http: HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Context-Type': 'application/json' });

  getAllItems(): Observable<Items[]> {
    return this.http.get<Items[]>('http://localhost:7000/items');
  }

}
