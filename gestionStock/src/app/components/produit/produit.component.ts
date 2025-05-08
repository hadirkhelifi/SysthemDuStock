import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Produit } from '../../models/produit';
import { ProduitService } from '../../services/produit.service';

@Component({
  selector: 'app-produit',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {
  produits: Produit[] = [];
  produit: Produit = { nom: '', categorie: '', prix: 0, fournisseur: '', seuilMin: 0 };
  editMode: boolean = false;

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.produitService.getAll().subscribe(data => this.produits = data);
  }

  save() {
    if (this.editMode && this.produit.id != null) {
      this.produitService.update(this.produit.id, this.produit).subscribe(() => {
        this.getAll();
        this.resetForm();
      });
    } else {
      this.produitService.create(this.produit).subscribe(() => {
        this.getAll();
        this.resetForm();
      });
    }
  }

  edit(p: Produit) {
    this.produit = { ...p };
    this.editMode = true;
  }

  remove(produit: Produit) {
    if (produit.id != null && confirm('Confirmer la suppression ?')) {
      this.produitService.delete(produit.id).subscribe(() => this.getAll());
    }
  }

  resetForm() {
    this.produit = { nom: '', categorie: '', prix: 0, fournisseur: '', seuilMin: 0 };
    this.editMode = false;
  }
}
