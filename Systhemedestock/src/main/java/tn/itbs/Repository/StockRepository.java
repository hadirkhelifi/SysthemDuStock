package tn.itbs.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.itbs.Models.Entrepot;
import tn.itbs.Models.Produit;
import tn.itbs.Models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	
	  Optional<Stock> findByProduitIdAndEntrepotId(Long produitId, Long entrepotId);
	Optional<Stock> findByProduitAndEntrepot(Produit produit, Entrepot entrepot);
	   @Query("SELECT s FROM Stock s WHERE s.quantite < s.seuilAlerte")
	    List<Stock> findStocksEnAlerte();



}
