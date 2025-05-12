import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../../services/notification.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-fornisseur-home',
  standalone: true,
    imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './fornisseur-home.component.html',
  styleUrl: './fornisseur-home.component.css'
})
export class FornisseurHomeComponent implements OnInit {
  alertMessage: string = '';

 constructor(private notificationService: NotificationService) {}

  ngOnInit(): void {
  this.notificationService.currentMessage.subscribe(message => {
    if (message) {
      console.log("🔔 Message reçu :", message); // ✅ Log pour test
      this.alertMessage = message;
      setTimeout(() => {
        this.alertMessage = '';
      }, 5000);
    }
  });
}


}
