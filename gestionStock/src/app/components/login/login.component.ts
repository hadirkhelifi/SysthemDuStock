import { Component } from '@angular/core';
import { AuthService, LoginRequest } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] // Si vous avez un fichier CSS spécifique
})
export class LoginComponent {
  email = '';
  motDePasse = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
  const data: LoginRequest = {
    email: this.email,
    motDePasse: this.motDePasse
  };

  this.authService.login(data).subscribe({
    next: (res) => {
      // Stocker le token et le rôle
      localStorage.setItem('token', res.token);
      localStorage.setItem('role', res.role);

      alert('Connexion réussie');

      // Redirection selon le rôle
      switch (res.role) {
  case 'ADMINISTRATEUR':
    this.router.navigate(['AdminHome']);
    break;
  case 'EMPLOYE':
    this.router.navigate(['EmployeHome']);
    break;
  case 'FOURNISSEUR':
    this.router.navigate(['FornisseurHome']);
    break;
  default:
    alert('Rôle inconnu : ' + res.role);
    // Facultatif : rediriger vers une page d'erreur ou login
    this.router.navigate(['login']);
    break;
}

    },
    error: (err) => {
      console.error(err);
      alert('Erreur de connexion');
    }
  });
}

}
