package tn.itbs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.Models.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {

}
