package tn.itbs.Service;

import tn.itbs.Models.Entrepot;
import java.util.List;

public interface EntrepotService  {
	 Entrepot ajouterEntrepot(Entrepot entrepot);
	    Entrepot modifierEntrepot(Long id, Entrepot entrepot);
	    void supprimerEntrepot(Long id);
	    Entrepot getEntrepot(Long id);
	    List<Entrepot> getAllEntrepots();

}
