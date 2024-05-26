package it.epicode.gestioneDispositivi.repositories;

import it.epicode.gestioneDispositivi.models.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
}
