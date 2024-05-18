package it.epicode.gestionePrenotazioni.beans;

import it.epicode.gestionePrenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Postazione {

    @Id
    @GeneratedValue
    private int id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_postazione")
    private TipoPostazione tipoPostazione;

    @Column(name = "max_occupanti")
    private int maxOccupanti;

    //many to one edificio
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


    public int getMaxOccupanti() {
        return maxOccupanti;
    }
}
