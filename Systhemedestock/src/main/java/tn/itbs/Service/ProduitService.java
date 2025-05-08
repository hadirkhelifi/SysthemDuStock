package tn.itbs.Service;
import tn.itbs.Models.Produit;
import java.util.List;
public interface ProduitService {
	
	 Produit ajouterProduit(Produit produit);
	    Produit modifierProduit(Long id, Produit produit);
	    void supprimerProduit(Long id);
	    Produit getProduit(Long id);
	    List<Produit> getAllProduits();

}
