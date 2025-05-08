import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Entrepot } from '../../models/entrepot';
import { EntrepotService } from '../../services/entrepot.service';


@Component({
  selector: 'app-entrepot',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './entrepot.component.html',
  styleUrls: ['./entrepot.component.css']
})
export class EntrepotComponent implements OnInit {
  entrepots: Entrepot[] = [];
  entrepot: Entrepot = { nom: '', adresse: '', capacite: 0 };
  editMode: boolean = false;

  constructor(private entrepotService: EntrepotService) {}

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.entrepotService.getAll().subscribe(data => this.entrepots = data);
  }
  
  save() {
    if (this.editMode) {
      if (this.entrepot.id != null && this.entrepot.id > 0) {
        this.entrepotService.update(this.entrepot.id, this.entrepot).subscribe({
          next: () => {
            this.getAll();
            this.resetForm();
          },
          error: err => {
            console.error('Erreur de mise à jour', err);
            alert("Erreur de mise à jour de l'entrepôt.");
          }
        });
      } else {
        alert('ID invalide pour la mise à jour.');
      }
    } else {
      this.entrepotService.create(this.entrepot).subscribe({
        next: () => {
          this.getAll();
          this.resetForm();
        },
        error: err => {
          console.error("Erreur d'ajout", err);
          alert("Erreur lors de l'ajout de l'entrepôt !");
        }
      });
    }
  }
  
  edit(entrepot: Entrepot) {
    this.entrepot = { ...entrepot };
    this.editMode = true;
  }
  
  remove(entrepot: Entrepot) {
    if (entrepot.id != null && confirm('Confirmer la suppression ?')) {
      this.entrepotService.delete(entrepot.id).subscribe(() => this.getAll());
    } else {
      alert("Impossible de supprimer : ID manquant.");
    }
  }
  resetForm() {
    this.entrepot = { id: 0, nom: '', adresse: '', capacite: 0 };
    this.editMode = false;
  }
}
