import { Routes } from '@angular/router';
import { EntrepotComponent } from './components/entrepot/entrepot.component';
import { ProduitComponent } from './components/produit/produit.component';
import { MouvementStockComponent } from './components/mouvement-stock/mouvement-stock.component';
import { StockComponent } from './components/stock/stock.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { FornisseurHomeComponent } from './components/fornisseur-home/fornisseur-home.component';
import { EmployeeHomeComponent } from './components/employee-home/employee-home.component';
export const routes: Routes = [
  //{ path: '', redirectTo: 'entrepots', pathMatch: 'full' },
  { path: 'entrepots', component: EntrepotComponent },
  { path: 'Produits', component: ProduitComponent },
  { path: 'mouvements', component: MouvementStockComponent },
  { path: 'stock',       component: StockComponent }, 
  { path: '', component: HomeComponent },
   { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'AdminHome', component: HomeComponent },
  { path: 'FornisseurHome', component: FornisseurHomeComponent },
  { path: 'EmployeeHome', component: EmployeeHomeComponent },

];
