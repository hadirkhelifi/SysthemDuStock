import { Produit } from './produit';
import { Entrepot } from './entrepot';

export interface MouvementStock {
  id?: number;
  produit: Produit;
  type: string; // "entrée" ou "sortie"
  quantite: number;
  date: string; // ou Date
  entrepot: Entrepot;
}
