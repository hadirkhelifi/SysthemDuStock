
// src/app/services/auth.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

export interface RegisterRequest {
  nom: string;
  email: string;
  motDePasse: string;
  role: string;
}

export interface LoginRequest {
  email: string;
  motDePasse: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth'; // adapte selon ton backend

  constructor(private http: HttpClient) {}

  register(data: RegisterRequest): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, data);
  }

  login(data: LoginRequest): Observable<any> {
  return this.http.post(`${this.apiUrl}/login`, data).pipe(
    tap((res: any) => {
      localStorage.setItem('token', res.token);
    })
  );
}
}