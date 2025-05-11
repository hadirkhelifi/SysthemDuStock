package tn.itbs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.Models.Stock;
import tn.itbs.Models.Utilisateur;
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
    
    
    
    
    @PostMapping("/{id}/alerte")
    public ResponseEntity<String> envoyerAlerte(@PathVariable Long id) {
        Stock stock = stockService.getStock(id); // utilise ta méthode déjà existante

        if (stock.getQuantite() >= stock.getSeuilAlerte()) {
            return ResponseEntity.badRequest().body("Pas besoin d'alerte. Le stock est suffisant.");
        }

        String produitNom = stock.getProduit().getNom();
        String entrepotNom = stock.getEntrepot().getNom();
        String message = "🛑 Le produit \"" + produitNom + "\" dans l'entrepôt \"" + entrepotNom + "\" est out of stock.";

        // Simuler l'envoi (affichage console ou log)
        System.out.println("📨 Alerte envoyée : " + message);

        return ResponseEntity.ok(message);
    }



}
