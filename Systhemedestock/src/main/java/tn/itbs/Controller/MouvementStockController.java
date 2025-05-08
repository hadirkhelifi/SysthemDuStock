package tn.itbs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.Models.MouvementStock;
import tn.itbs.Service.MouvementStockService;

@RestController
@RequestMapping("/api/mouvements")
@CrossOrigin(origins = "http://localhost:4200")
public class MouvementStockController {
	@Autowired
    private MouvementStockService mouvementService;

    @PostMapping
    public MouvementStock create(@RequestBody MouvementStock mouvement) {
        return mouvementService.ajouterMouvement(mouvement);
    }

    @GetMapping
    public List<MouvementStock> getAll() {
        return mouvementService.getAllMouvements();
    }

    @GetMapping("/{id}")
    public MouvementStock getById(@PathVariable Long id) {
        return mouvementService.getMouvement(id);
    }

    @PutMapping("/{id}")
    public MouvementStock update(@PathVariable Long id, @RequestBody MouvementStock mouvement) {
        return mouvementService.modifierMouvement(id, mouvement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mouvementService.supprimerMouvement(id);
    }

}
