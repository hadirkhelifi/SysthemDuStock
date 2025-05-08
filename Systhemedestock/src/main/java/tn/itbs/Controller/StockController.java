package tn.itbs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.Models.Stock;
import tn.itbs.Service.StockService;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
	@Autowired
    private StockService stockService;

    @PostMapping
    public Stock ajouterOuMettreAJourStock(@RequestBody Stock stock) {
        return stockService.ajouterOuMettreAJourStock(stock);
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable Long id) {
        return stockService.getStock(id);
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @DeleteMapping("/{id}")
    public void supprimerStock(@PathVariable Long id) {
        stockService.supprimerStock(id);
    }
    
    @GetMapping("/alertes")
    public List<Stock> getStocksEnAlerte() {
        return stockService.getStocksEnAlerte();
    }

}
