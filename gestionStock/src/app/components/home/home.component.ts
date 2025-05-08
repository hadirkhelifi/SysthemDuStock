import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // 👈 Obligatoire pour routerLink
import { CommonModule } from '@angular/common'; // 👈 Pour utiliser les directives Angular

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,   // directives Angular de base
    RouterModule    // pour que routerLink fonctionne
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {}
