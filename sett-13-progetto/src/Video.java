class Video extends ElementoMultimediale implements Volume, Luminosità{
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void play() {
        for (int i = 0; i < durata; i++) {
            for (int j = 0; i < volume; j++) {
                System.out.println("!");
                for (int k = 0; k < luminosita; k++) {
                    System.out.println("*");
                }
            }
        }

        System.out.println(" " + titolo);
    }

    public void aumentaLuminosita(){
        luminosita ++;
    }

    public void diminuisciLuminosita(){
        if (luminosita > 0){
            luminosita --;
        }
    }

    @Override
    public void esegui() {
        play();
    }

    @Override
    public void abbassaVolume() {

    }

    @Override
    public void alzaVolume() {

    }
}
