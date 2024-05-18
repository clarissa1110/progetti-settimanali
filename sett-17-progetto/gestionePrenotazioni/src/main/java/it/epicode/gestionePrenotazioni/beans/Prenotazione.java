package it.epicode.gestionePrenotazioni.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_username")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataPrenotazione=" + dataPrenotazione +
                ", postazione=" + postazione +
                '}';
    }
}
