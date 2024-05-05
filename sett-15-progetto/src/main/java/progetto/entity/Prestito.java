package progetto.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name ="prestito")
public class Prestito {

    @Id
    @GeneratedValue
    private int prestitoId;

    @OneToOne
    @JoinColumn(name = "elemento_prestato_isbn", nullable = false)
    private Prodotto prodotto;

    @Column(name = "inizio_prestito")
    private LocalDate inizioPrestito;

    @Column(name = "restituzione_prevista")
    private LocalDate restituzionePrevista; //inizioPrestito + 30 gg

    @Column(name = "restituzione_effettiva")
    private LocalDate restituzioneEffettiva;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Prestito(int prestitoId, Utente utente, Prodotto prodotto, LocalDate inizioPrestito, LocalDate restituzionePrevista, LocalDate restituzioneEffettiva){
        this.utente = utente;
        this.prodotto = prodotto;
        this.inizioPrestito = inizioPrestito;
        this.restituzionePrevista = restituzionePrevista;
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public Prestito(){}

    public int getPrestitoId() {
        return prestitoId;
    }

    public void setPrestitoId(int prestitoId) {
        this.prestitoId = prestitoId;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
        this.restituzionePrevista= inizioPrestito.plusDays(30);
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", prodotto=" + prodotto +
                ", inizioPrestito=" + inizioPrestito +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzioneEffettiva=" + restituzioneEffettiva +
                '}';
    }
}
