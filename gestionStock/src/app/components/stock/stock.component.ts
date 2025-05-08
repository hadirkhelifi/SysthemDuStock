import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Stock } from '../../models/stock';
import { StockService } from '../../services/stock.service';
import { Produit } from '../../models/produit';
import { Entrepot } from '../../models/entrepot';

@Component({
  selector: 'app-stock',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  stocks: Stock[] = [];

  constructor(private stockService: StockService) {}

  ngOnInit(): void {
    this.loadStocks();
  }

  loadStocks() {
    this.stockService.getAll().subscribe(data => this.stocks = data);
  }

  isStockBas(stock: Stock): boolean {
    return stock.quantite < stock.seuilAlerte;
  }
}
