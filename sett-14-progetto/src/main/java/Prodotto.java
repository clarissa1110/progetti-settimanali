public abstract class Prodotto implements Dati{
    protected int codiceISBN;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    public Prodotto(int codiceISBN, String titolo, int annoPubblicazione, int numeroPagine){
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public int getCodiceISBN(){
        return codiceISBN;
    }

    public String getTitolo(){
        return titolo;
    }

    public int getAnnoPubblicazione(){
        return annoPubblicazione;
    }

    public int getNumeroPagine(){
        return  numeroPagine;
    }

    public void setCodiceISBN(int codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
