package tn.itbs.Service;
import tn.itbs.Models.Stock;

import java.util.List;


public interface StockService {
	Stock getById(Long id);
	Stock ajouterOuMettreAJourStock(Stock stock);
    Stock getStock(Long id);
    List<Stock> getAllStocks();
    void supprimerStock(Long id);
    List<Stock> getStocksEnAlerte();
    


}
