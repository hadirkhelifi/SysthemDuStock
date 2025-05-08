import { Component, OnInit } from '@angular/core';
import { MouvementStock } from '../../models/mouvement-stock';
import { MouvementStockService } from '../../services/mouvement-stock.service';
import { ProduitService } from '../../services/produit.service';
import { EntrepotService } from '../../services/entrepot.service';
import { Produit } from '../../models/produit';
import { Entrepot } from '../../models/entrepot';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-mouvement-stock',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './mouvement-stock.component.html',
  styleUrls: ['./mouvement-stock.component.css']
})
export class MouvementStockComponent implements OnInit {
  mouvements: MouvementStock[] = [];
  mouvement: MouvementStock = {
    produit: {} as Produit,
    type: '',
    quantite: 0,
    date: '',
    entrepot: {} as Entrepot
  };
  produits: Produit[] = [];
  entrepots: Entrepot[] = [];
  editMode = false;

  constructor(
    private service: MouvementStockService,
    private produitService: ProduitService,
    private entrepotService: EntrepotService
  ) {}

  ngOnInit(): void {
    this.getAll();
    this.produitService.getAll().subscribe(data => this.produits = data);
    this.entrepotService.getAll().subscribe(data => this.entrepots = data);
  }

  getAll() {
    this.service.getAll().subscribe(data => this.mouvements = data);
  }

  save() {
    if (this.editMode && this.mouvement.id) {
      this.service.update(this.mouvement.id, this.mouvement).subscribe(() => {
        this.getAll();
        this.resetForm();
      });
    } else {
      this.service.create(this.mouvement).subscribe(() => {
        this.getAll();
        this.resetForm();
      });
    }
  }

  edit(m: MouvementStock) {
    this.mouvement = { ...m };
    this.editMode = true;
  }

  remove(m: MouvementStock) {
    if (m.id && confirm('Confirmer la suppression ?')) {
      this.service.delete(m.id).subscribe(() => this.getAll());
    }
  }

  resetForm() {
    this.mouvement = {
      produit: {} as Produit,
      type: '',
      quantite: 0,
      date: '',
      entrepot: {} as Entrepot
    };
    this.editMode = false;
  }
}
