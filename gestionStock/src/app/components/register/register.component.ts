import { Component } from '@angular/core';
import { AuthService, RegisterRequest } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],

  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'] // Si vous avez un fichier CSS spécifique
})
export class RegisterComponent {
  nom = '';
  email = '';
  motDePasse = '';
  role = '';

  constructor(private authService: AuthService, private router: Router) {}

  register() {
    const data: RegisterRequest = {
      nom: this.nom,
      email: this.email,
      motDePasse: this.motDePasse,
      role: this.role
    };

    this.authService.register(data).subscribe({
      next: () => {
        alert('Inscription réussie');
        this.router.navigate(['/login']);
      },
      error: (err) => alert('Erreur : ' + err.error.message)
    });
  }
}
