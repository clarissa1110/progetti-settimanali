public class Riviste extends Prodotto{
    public enum Periodico {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    private Periodico periodico;

    public Riviste(int codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodico periodico) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodico = periodico;
    }

    public Periodico getPeriodico() {
        return periodico;
    }

    public void setPeriodico(Periodico periodico) {
        this.periodico = periodico;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "codice ISBN = " + codiceISBN +
                ", Titolo = " + titolo +
                ", Anno di pubblicazione = " + annoPubblicazione +
                ", Numero di pagine = " + numeroPagine +
                ", Periodicità = " + periodico +
                "}";
    }
}
