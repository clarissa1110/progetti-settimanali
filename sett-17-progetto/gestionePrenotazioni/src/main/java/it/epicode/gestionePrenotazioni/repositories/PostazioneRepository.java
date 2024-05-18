package it.epicode.gestionePrenotazioni.repositories;

import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    @Query("SELECT p FROM Postazione p JOIN p.edificio e WHERE p.tipoPostazione = :tipo AND e.citta = :citta")
    public List<Postazione> ricercaPostazioniPerTipoECitta(@Param("tipo") TipoPostazione tipoPostazione, @Param("citta") String citta);

}
