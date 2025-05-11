package tn.itbs.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


import tn.itbs.Models.Stock;
import tn.itbs.Repository.StockRepository;
import tn.itbs.Service.StockService;



@Service
public class StockServiceImpl implements StockService {
	@Autowired
    private StockRepository stockRepository;
    @Override
    public Stock ajouterOuMettreAJourStock(Stock stock) {
    	Optional<Stock> existingStock = stockRepository
    		    .findByProduitAndEntrepot(stock.getProduit(), stock.getEntrepot());

        if (existingStock.isPresent()) {
            Stock s = existingStock.get();
            s.setQuantite(stock.getQuantite());
            s.setSeuilAlerte(stock.getSeuilAlerte());
            return stockRepository.save(s);
        } else {
            return stockRepository.save(stock);
        }
    }

    @Override
    public Stock getStock(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock introuvable avec ID : " + id));
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void supprimerStock(Long id) {
        stockRepository.deleteById(id);
    }
    @Override
    public List<Stock> getStocksEnAlerte() {
        return stockRepository.findStocksEnAlerte();
    }
    @Override
    public Stock getById(Long id) {
        return stockRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("❌ Stock avec ID " + id + " non trouvé"));
    }


}
