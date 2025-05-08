package tn.itbs.Controller;

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

import tn.itbs.Models.Entrepot;
import tn.itbs.Service.EntrepotService;
import java.util.List;

@RestController
@RequestMapping("/api/entrepots")
@CrossOrigin(origins = "http://localhost:4200")
public class EntrepotController {
	
	@Autowired
    private EntrepotService entrepotService;

    @GetMapping
    public List<Entrepot> getAllEntrepots() {
        return entrepotService.getAllEntrepots();
    }

    @GetMapping("/{id}")
    public Entrepot getEntrepot(@PathVariable Long id) {
        return entrepotService.getEntrepot(id);
    }

    @PostMapping
    public Entrepot ajouterEntrepot(@RequestBody Entrepot entrepot) {
        return entrepotService.ajouterEntrepot(entrepot);
    }

    @PutMapping("/{id}")
    public Entrepot modifierEntrepot(@PathVariable Long id, @RequestBody Entrepot entrepot) {
        return entrepotService.modifierEntrepot(id, entrepot);
    }

    @DeleteMapping("/{id}")
    public void supprimerEntrepot(@PathVariable Long id) {
        entrepotService.supprimerEntrepot(id);
    }

}
