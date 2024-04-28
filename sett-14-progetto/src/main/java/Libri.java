import java.util.Objects;

public class Libri extends Prodotto{

    private String autore;
    private String genere;

    public Libri(int codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere){
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore(){
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString(){
        return "Libro{" +
                "Codice ISBN = " + codiceISBN +
                ", Autore = " + autore +
                ", Titolo = " + titolo +
                ", Anno di pubblicazione = " + annoPubblicazione +
                ", Numero di pagine = " + numeroPagine +
                ", Genere = " + genere +
                "}";

    }
}
