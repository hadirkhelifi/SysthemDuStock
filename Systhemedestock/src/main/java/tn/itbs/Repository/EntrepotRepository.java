package tn.itbs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.itbs.Models.Entrepot;

@Repository
public interface EntrepotRepository extends JpaRepository<Entrepot, Long> {

}
