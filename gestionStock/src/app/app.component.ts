import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  template: `
    <nav>
      <a routerLink="/entrepots">Entrepôts</a>
    </nav>
    <router-outlet></router-outlet>
  `
})

export class AppComponent {
  title = 'gestionStock';
  constructor() {}
}