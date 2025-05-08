import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MouvementStock } from '../models/mouvement-stock';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MouvementStockService {
  private url = 'http://localhost:8080/api/mouvements';

  constructor(private http: HttpClient) {}

  getAll(): Observable<MouvementStock[]> {
    return this.http.get<MouvementStock[]>(this.url);
  }

  create(mouvement: MouvementStock): Observable<any> {
    return this.http.post(this.url, mouvement);
  }

  update(id: number, mouvement: MouvementStock): Observable<any> {
    return this.http.put(`${this.url}/${id}`, mouvement);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}
