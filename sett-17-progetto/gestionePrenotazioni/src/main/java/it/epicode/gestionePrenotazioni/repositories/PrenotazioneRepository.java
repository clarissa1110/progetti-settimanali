package it.epicode.gestionePrenotazioni.repositories;

import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;
import it.epicode.gestionePrenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
   // List<Prenotazione> findByPostazioneAndData(int postazioneId, LocalDate dataPrenotazione);
   // List<Prenotazione> findByUtenteAndData(String usernameUtente, LocalDate dataPrenotazione);

    @Query("SELECT pre FROM Prenotazione pre JOIN pre.postazione p WHERE p.id = :postazioneId AND pre.dataPrenotazione = :dataPrenotazione")
    public List<Prenotazione> findByPostazioneAndData(@Param("postazioneId") int id, @Param("dataPrenotazione") LocalDate dataPrenotazione);

    @Query("SELECT pre FROM Prenotazione pre JOIN pre.utente u WHERE u.username = :username AND pre.dataPrenotazione = :dataPrenotazione")
    public List<Prenotazione> findByUtenteAndData(@Param("username") String username, @Param("dataPrenotazione") LocalDate dataPrenotazione);

}
