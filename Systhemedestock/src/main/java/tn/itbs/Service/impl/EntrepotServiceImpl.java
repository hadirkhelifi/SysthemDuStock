package tn.itbs.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.Models.Entrepot;
import tn.itbs.Repository.EntrepotRepository;
import tn.itbs.Service.EntrepotService;


@Service
public class EntrepotServiceImpl implements EntrepotService {

    @Autowired
    private EntrepotRepository entrepotRepository;

    @Override
    public Entrepot ajouterEntrepot(Entrepot entrepot) {
        return entrepotRepository.save(entrepot);
    }

    @Override
    public Entrepot modifierEntrepot(Long id, Entrepot entrepot) {
        Optional<Entrepot> optionalEntrepot = entrepotRepository.findById(id);
        if (optionalEntrepot.isPresent()) {
            Entrepot existing = optionalEntrepot.get();
            existing.setNom(entrepot.getNom());
            existing.setAdresse(entrepot.getAdresse());
            existing.setCapacite(entrepot.getCapacite());
            return entrepotRepository.save(existing);
        } else {
            throw new RuntimeException("Entrepôt introuvable avec ID : " + id);
        }
    }

    @Override
    public void supprimerEntrepot(Long id) {
        entrepotRepository.deleteById(id);
    }

    @Override
    public Entrepot getEntrepot(Long id) {
        return entrepotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrepôt introuvable avec ID : " + id));
    }

    @Override
    public List<Entrepot> getAllEntrepots() {
        return entrepotRepository.findAll();
    }
}
