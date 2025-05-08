package tn.itbs.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entrepots")
public class Entrepot {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nom;
	    private String adresse;
	    private int capacite;

	    // Getters et Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public int getCapacite() {
	        return capacite;
	    }

	    public void setCapacite(int capacite) {
	        this.capacite = capacite;
	    }

}
