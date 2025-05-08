package tn.itbs.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class MouvementStock {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    private Produit produit;

	    private String type; // "entrée" ou "sortie"

	    private int quantite;

	    private LocalDate date;

	    @ManyToOne
	    private Entrepot entrepot;

	    // Getters et Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Produit getProduit() {
	        return produit;
	    }

	    public void setProduit(Produit produit) {
	        this.produit = produit;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public int getQuantite() {
	        return quantite;
	    }

	    public void setQuantite(int quantite) {
	        this.quantite = quantite;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    public Entrepot getEntrepot() {
	        return entrepot;
	    }

	    public void setEntrepot(Entrepot entrepot) {
	        this.entrepot = entrepot;
	    }
	

}
