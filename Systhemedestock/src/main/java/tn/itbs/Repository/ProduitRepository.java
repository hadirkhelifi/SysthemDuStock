package tn.itbs.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.Models.Produit;
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
