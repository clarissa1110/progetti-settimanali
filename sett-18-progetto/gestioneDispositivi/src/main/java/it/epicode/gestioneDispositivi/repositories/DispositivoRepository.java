package it.epicode.gestioneDispositivi.repositories;

import it.epicode.gestioneDispositivi.models.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {
}
