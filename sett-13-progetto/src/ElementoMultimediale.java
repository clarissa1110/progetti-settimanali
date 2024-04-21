import java.util.Scanner;

abstract class ElementoMultimediale {
    protected String titolo;
    protected int durata;

    public ElementoMultimediale(String titolo, int durata){
        this.titolo = titolo;
        this.durata = durata;
    }

    public abstract void esegui();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] lettoreMultimediale = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++){
            System.out.println("Che tipo di elemento vuoi riprodurre? Scrivi 1 per audio, 2 per video o 3 per immagine");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Scrivi il titolo dell'elemento: ");
            String titolo = scanner.nextLine();

            System.out.println("Scrivi la durata dell'elemento: ");
            int durata = scanner.nextInt();

            switch (tipo) {
                case (1):
                    System.out.println("A che volume vuoi riprodurre l'elemento audio?");
                    int volume = scanner.nextInt();
                    lettoreMultimediale[i] = new Audio(titolo, durata, volume);
                    break;
                case (2):
                    System.out.println("A che volume vuoi riprodurre l'elemento video?");
                    volume = scanner.nextInt();
                    System.out.println("Con quanta luminosità vuoi riprodurre l'elemento video?");
                    int luminosita = scanner.nextInt();
                    lettoreMultimediale[i] = new Video(titolo, durata, volume, luminosita);
                    break;
                case(3):
                    System.out.println("Con quanta luminosità vuoi riprodurre l'elemento immagine?");
                    luminosita = scanner.nextInt();
                    lettoreMultimediale[i]= new Immagine(titolo, luminosita);
            }
        }
        int scelta;
        do {
            System.out.println("Quale elemento vuoi riprodurre? Scrivi un numero compreso tra 1 e 5; scrivi 0 per interrompere l'applicazione");
            scelta = scanner.nextInt();

            if (scelta > 0 && scelta <= 5) {
                lettoreMultimediale[scelta - 1].esegui();
            }
        } while (scelta != 0);
    }


}
