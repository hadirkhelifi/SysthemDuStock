import { Routes } from '@angular/router';
import { EntrepotComponent } from './components/entrepot/entrepot.component';
import { ProduitComponent } from './components/produit/produit.component';
import { MouvementStockComponent } from './components/mouvement-stock/mouvement-stock.component';
import { StockComponent } from './components/stock/stock.component';
export const routes: Routes = [
  //{ path: '', redirectTo: 'entrepots', pathMatch: 'full' },
  { path: 'entrepots', component: EntrepotComponent },
  { path: 'Produits', component: ProduitComponent },
  { path: 'mouvements', component: MouvementStockComponent },
  { path: 'stock',       component: StockComponent }, 

];
