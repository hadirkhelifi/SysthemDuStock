package tn.itbs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.Service.ProduitService;
import java.util.List;
import tn.itbs.Models.Produit;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/produits")
public class ProduitController {
	
	@Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAll() {
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit create(@RequestBody Produit produit) {
        return produitService.ajouterProduit(produit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getById(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.getProduit(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> update(@PathVariable Long id, @RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.modifierProduit(id, produit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return ResponseEntity.noContent().build();
    }

}
