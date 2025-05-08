import { Produit } from './produit';
import { Entrepot } from './entrepot';
export interface Stock {
    id?: number;
    quantite: number;
    seuilAlerte: number;
    produit: Produit;
    entrepot: Entrepot;
  }
  