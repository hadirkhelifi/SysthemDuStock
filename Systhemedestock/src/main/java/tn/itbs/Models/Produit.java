package tn.itbs.Models;

import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String categorie;
    private float prix;
    private String fournisseur;
    private int seuilMin;

    // Getters et Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getCategorie() { return categorie; }

    public void setCategorie(String categorie) { this.categorie = categorie; }

    public float getPrix() { return prix; }

    public void setPrix(float prix) { this.prix = prix; }

    public String getFournisseur() { return fournisseur; }

    public void setFournisseur(String fournisseur) { this.fournisseur = fournisseur; }

    public int getSeuilMin() { return seuilMin; }

    public void setSeuilMin(int seuilMin) { this.seuilMin = seuilMin; }
}
