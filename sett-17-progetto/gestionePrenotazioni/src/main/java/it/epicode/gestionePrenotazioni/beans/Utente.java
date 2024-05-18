package it.epicode.gestionePrenotazioni.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Utente {

    @Id
    private String username;

    @Column(name = "nome_cognome")
    private String nomeCognome;

    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;
}
