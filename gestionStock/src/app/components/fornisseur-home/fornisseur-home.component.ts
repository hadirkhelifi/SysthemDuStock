import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../../services/notification.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fornisseur-home',
  standalone: true,
    imports: [CommonModule, FormsModule],
  templateUrl: './fornisseur-home.component.html',
  styleUrl: './fornisseur-home.component.css'
})
export class FornisseurHomeComponent implements OnInit {
  alertMessage: string = '';

  constructor(private notificationService: NotificationService) {}

  ngOnInit(): void {
    // S'abonner au service pour recevoir les alertes
    this.notificationService.currentMessage.subscribe(message => {
      this.alertMessage = message; // Mettre à jour le message d'alerte
    });
  }

}
