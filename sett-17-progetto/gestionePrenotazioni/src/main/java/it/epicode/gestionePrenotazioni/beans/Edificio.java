package it.epicode.gestionePrenotazioni.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Edificio {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String indirizzo;
    private String citta;

}
