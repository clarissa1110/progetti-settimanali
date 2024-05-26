package it.epicode.gestioneDispositivi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.gestioneDispositivi.enums.Stato;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo {

    @Id
    @GeneratedValue
    private int id;
    private Stato stato;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    @JsonIgnore
    private Dipendente dipendente;
}
