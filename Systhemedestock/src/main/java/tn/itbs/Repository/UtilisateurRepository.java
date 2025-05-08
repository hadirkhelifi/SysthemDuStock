package tn.itbs.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.Models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	 Optional<Utilisateur> findByEmail(String email);

}
