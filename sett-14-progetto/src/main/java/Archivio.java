import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;


public class Archivio {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Libri libro1 = new Libri(123, "La Compagnia dell'Anello", 1954, 609, "J.R.R. Tolkien", "Fantasy");
        Libri libro2 = new Libri(456, "Le Due Torri", 1954, 509, "J.R.R. Tolkien", "Fantasy");
        Libri libro3 = new Libri(789, "Il Ritorno del Re", 1955, 422, "J.R.R. Tolkien", "Fantasy");
        Libri libro4 = new Libri(321, "Racconto di Due Città", 1859, 462, "Charles Dickens", "Romanzo storico");
        Libri libro5 = new Libri(654, "Dracula", 1897, 503, "Bram Stoker", "Horror fiction");
        Libri libro6 = new Libri(987, "Cime Tempestose", 1847, 461, "Emily Bronte", "Tragedia");

        List<Libri> listaLibri = List.of(libro1, libro2, libro3, libro4, libro5, libro6);


        Riviste rivista1 = new Riviste(321, "Mani di fata", 2024, 80, Riviste.Periodico.MENSILE);
        Riviste rivista2 = new Riviste(654, "Settimana Enigmistica", 2024, 46, Riviste.Periodico.SETTIMANALE);
        Riviste rivista3 = new Riviste(987, "National Geographic Magazine", 2024, 76, Riviste.Periodico.MENSILE);

        List<Riviste> listaRiviste = List.of(rivista1, rivista2, rivista3);


        List<Prodotto> archivio = new ArrayList<>();
        archivio.add(libro1);
        archivio.add(libro2);
        archivio.add(libro3);
        archivio.add(libro5);
        archivio.add(libro6);
        archivio.add(rivista1);
        archivio.add(rivista2);


        System.out.println("Stampa lista documenti iniziale:");
        archivio.forEach(System.out::println);
        System.out.println();

        //Aggiunta di un elemento
        archivio.add(new Libri(321, "Racconto di Due Città", 1859, 462, "Charles Dickens", "Romanzo storico"));
        archivio.add(new Riviste(987, "National Geographic Magazine", 2024, 76, Riviste.Periodico.MENSILE));
        System.out.println("Stampa lista documenti dopo l'aggiunta di un nuovo elemento:");
        archivio.forEach(System.out::println);
        System.out.println();

        //Rimozione di un elemento dato un codice ISBN
        System.out.println("Inserisci il codice ISBN del documento che vuoi eliminare:");
        int codiceRicerca = scanner.nextInt();
        archivio.removeIf(doc -> doc.codiceISBN == codiceRicerca);
        System.out.println("Stampa lista documenti dopo la rimozione di un elemento");
        archivio.forEach(System.out::println);
        System.out.println();
        scanner.nextLine();

        //Ricerca per codice ISBN
        System.out.println("Inserisci il codice ISBN del documento che vuoi cercare:");
        int ricercaISBN = scanner.nextInt();
        System.out.println("Risultato della ricerca per codice ISBN:");
        Optional<Prodotto> cercaPerISBN = archivio.stream()
                .filter(doc -> doc.getCodiceISBN() == ricercaISBN)
                .findFirst();
        if (cercaPerISBN.isPresent()) {
            System.out.println(cercaPerISBN.get());
        } else {
            throw new Exception("Questo codice non corrisponde a nessun documento nel nostro archivio");
        }
        System.out.println();

        //Ricerca per anno di pubblicazione
        System.out.println("Inserisci l'anno di pubblicazione per il quale vuoi eseguire la ricerca:");
        int ricercaAnno = scanner.nextInt();
        List<Prodotto> ricercaPerAnno = archivio.stream()
                .filter(libro -> libro.getAnnoPubblicazione() == ricercaAnno)
                .toList();
        if (!ricercaPerAnno.isEmpty()) {
            System.out.println("Risultato della ricerca per anno di pubblicazione:");
            ricercaPerAnno.forEach(System.out::println);
        } else {
            throw new Exception("Nel nostro archivio non è presente nessun libro pubblicato nell'anno indicato");
        }
        System.out.println();
        scanner.nextLine();

        //Ricerca per autore
        System.out.println("Inserisci il nome dell'autore per il quale vuoi eseguire la ricerca:");
        String nomeAutore = scanner.nextLine();
        List<Libri> ricercaPerAutore = listaLibri.stream()
                .filter(libro -> libro.getAutore().equals(nomeAutore))
                .toList();
        if (!ricercaPerAutore.isEmpty()) {
            System.out.println("Risultato della ricerca per autore:");
            ricercaPerAutore.forEach(System.out::println);
        } else {
            throw new Exception("Nel nostro archivio non è presente nessun libro dell'autore indicato");
        }
        System.out.println();


        String archivioString = archivio.stream()
                .map(doc -> doc.getCodiceISBN() + "@" + doc.getTitolo() + "@" + doc.getAnnoPubblicazione() + "@" + doc.getNumeroPagine())
                .collect(Collectors.joining("#"));
        //System.out.println(archivioString);

        //Salvataggio su disco
        File file = new File("./../persistence/archivio.txt");
        try {
            FileUtils.writeStringToFile(file, archivioString, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Caricamento dal disco
        try {
            String str = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] archivioStr = str.split("#");
            archivioStr = str.split("@");
            Arrays.stream(archivioStr).forEach(s -> System.out.println(s));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

