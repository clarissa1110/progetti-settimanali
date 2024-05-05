package progetto.entity;

import javax.persistence.Entity;

@Entity
public class Libri extends Prodotto{
    private String autore;
    private String genere;

    public Libri(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere){
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libri(String autore, String genere){
        this.autore = autore;
        this.genere = genere;
    }

    public Libri(){}

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
