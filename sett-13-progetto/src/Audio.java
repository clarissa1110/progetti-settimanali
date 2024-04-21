class Audio extends ElementoMultimediale implements Volume{
    private int volume;

    public Audio(String titolo, int durata, int volume){
        super(titolo, durata);
        this.volume = volume;
    }

    public int getVolume(){
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void play(){
        for (int i = 0; i < durata; i++) {
            for (int j = 0; j < volume; j++){
                System.out.println("!");
            }

            System.out.println(titolo.concat(" "));
        }


    }

    public void abbassaVolume(){
        if (volume > 0) {
            volume --;
        }
    }

    public void alzaVolume(){
      volume ++;
    }


    @Override
    public void esegui() {
        play();
    }
}
