public class Immagine extends ElementoMultimediale implements Luminosità{
    private int luminosita;

    public Immagine(String titolo, int luminosita){
        super(titolo, 0);
        this.luminosita = luminosita;
    }

    @Override
    public void aumentaLuminosita() {};

    @Override
    public void diminuisciLuminosita() {};

    public void show(){
        for (int k = 0; k < luminosita; k++){
            System.out.println("*");
        }
        System.out.println(" " + titolo);
    }

    @Override
    public void esegui() {
        show();
    }
}
