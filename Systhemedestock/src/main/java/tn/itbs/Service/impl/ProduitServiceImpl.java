package tn.itbs.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.itbs.Models.Produit;
import tn.itbs.Repository.ProduitRepository;
import tn.itbs.Service.ProduitService;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {  // 👈 ici on implémente bien l'interface

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit modifierProduit(Long id, Produit produit) {
        Produit existing = produitRepository.findById(id).orElseThrow();
        existing.setNom(produit.getNom());
        existing.setCategorie(produit.getCategorie());
        existing.setPrix(produit.getPrix());
        existing.setFournisseur(produit.getFournisseur());
        existing.setSeuilMin(produit.getSeuilMin());
        return produitRepository.save(existing);
    }

    @Override
    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
