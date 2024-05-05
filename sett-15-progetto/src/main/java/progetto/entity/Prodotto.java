package progetto.entity;

import javax.persistence.*;

@Entity
@Table(name="prodotti")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codiceISBN;

    @Column(nullable = false, length = 50)
    private String titolo;

    @Column(nullable = false, name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column(name = "numero_pagine")
    private int numeroPagine;

    @OneToOne(mappedBy = "prodotto")
    private Prestito prestito;


    public Prodotto(String titolo, int annoPubblicazione, int numeroPagine){
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Prodotto(){}

    public int getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(int codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }


}
