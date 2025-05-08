package tn.itbs.Service;
import tn.itbs.Models.MouvementStock;

import java.util.List;

public interface MouvementStockService {
	MouvementStock ajouterMouvement(MouvementStock mouvement);
    MouvementStock modifierMouvement(Long id, MouvementStock mouvement);
    void supprimerMouvement(Long id);
    MouvementStock getMouvement(Long id);
    List<MouvementStock> getAllMouvements();

}
