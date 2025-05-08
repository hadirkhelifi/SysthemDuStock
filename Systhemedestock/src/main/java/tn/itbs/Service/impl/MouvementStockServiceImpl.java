package tn.itbs.Service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.Models.Entrepot;
import tn.itbs.Models.MouvementStock;
import tn.itbs.Models.Produit;
import tn.itbs.Models.Stock;
import tn.itbs.Repository.MouvementStockRepository;
import tn.itbs.Repository.StockRepository;
import tn.itbs.Service.MouvementStockService;

@Service
public class MouvementStockServiceImpl implements MouvementStockService {

    @Autowired
    private MouvementStockRepository mouvementRepo;

    @Autowired
    private StockRepository stockRepo;

    @Override
    public MouvementStock ajouterMouvement(MouvementStock mouvement) {
        Produit produit = mouvement.getProduit();
        Entrepot entrepot = mouvement.getEntrepot();
        int quantite = mouvement.getQuantite();
        String type = mouvement.getType();

        // Chercher le stock existant pour ce produit dans cet entrepôt
        Optional<Stock> optStock = stockRepo.findByProduitAndEntrepot(produit, entrepot);
        Stock stock = optStock.orElseGet(() -> {
            Stock newStock = new Stock();
            newStock.setProduit(produit);
            newStock.setEntrepot(entrepot);
            newStock.setQuantite(0);
            return newStock;
        });

        // Appliquer la logique en fonction du type de mouvement
        if ("entrée".equalsIgnoreCase(type)) {
            stock.setQuantite(stock.getQuantite() + quantite);
        } else if ("sortie".equalsIgnoreCase(type)) {
            if (stock.getQuantite() < quantite) {
                throw new RuntimeException("Stock insuffisant pour la sortie !");
            }
            stock.setQuantite(stock.getQuantite() - quantite);
        } else {
            throw new IllegalArgumentException("Type de mouvement invalide : doit être 'entrée' ou 'sortie'");
        }

        // Sauvegarder le mouvement et le stock mis à jour
        mouvement.setDate(LocalDate.now());
        mouvementRepo.save(mouvement);
        stockRepo.save(stock);

        return mouvement;
    }

    @Override
    public MouvementStock modifierMouvement(Long id, MouvementStock mouvement) {
        // (Tu peux plus tard ajouter la logique pour modifier un mouvement, ici on laisse vide ou simple)
        return null;
    }

    @Override
    public void supprimerMouvement(Long id) {
        mouvementRepo.deleteById(id);
    }

    @Override
    public MouvementStock getMouvement(Long id) {
        return mouvementRepo.findById(id).orElse(null);
    }

    @Override
    public List<MouvementStock> getAllMouvements() {
        return mouvementRepo.findAll();
    }
}