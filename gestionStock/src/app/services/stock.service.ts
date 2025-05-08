import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Stock } from '../models/stock';

@Injectable({
  providedIn: 'root'
})
export class StockService {
  private url = 'http://localhost:8080/api/stocks';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Stock[]> {
    return this.http.get<Stock[]>(this.url);
  }

  create(stock: Stock): Observable<Stock> {
    return this.http.post<Stock>(this.url, stock);
  }

  update(id: number, stock: Stock): Observable<Stock> {
    return this.http.put<Stock>(`${this.url}/${id}`, stock);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
