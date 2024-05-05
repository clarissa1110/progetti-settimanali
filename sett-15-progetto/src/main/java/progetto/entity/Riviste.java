package progetto.entity;

import progetto.enums.Periodico;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Riviste extends  Prodotto{

    @Enumerated(EnumType.STRING)
    private Periodico periodico;

    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodico periodico){
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodico = periodico;
    }

    public Riviste(Periodico periodico){
        this.periodico = periodico;
    }

    public Riviste(){}

    public Periodico getPeriodico() {
        return periodico;
    }

    public void setPeriodico(Periodico periodico) {
        this.periodico = periodico;
    }
}
