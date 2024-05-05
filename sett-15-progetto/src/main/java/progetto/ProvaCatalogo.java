package progetto;

import progetto.dao.LibriDao;
import progetto.dao.PrestitoDao;
import progetto.dao.ProdottoDao;
import progetto.dao.UtenteDao;
import progetto.entity.*;
import progetto.enums.Periodico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;

public class ProvaCatalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_catalogo");
        EntityManager em = emf.createEntityManager();

        ProdottoDao prodottoDao = new ProdottoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);
        LibriDao libriDao = new LibriDao(em);

        Libri l1 = new Libri();
        l1.setTitolo("La Compagnia dell'Anello");
        l1.setAnnoPubblicazione(1954);
        l1.setNumeroPagine(609);
        l1.setAutore("J.R.R. Tolkien");
        l1.setGenere("Fantasy");

        prodottoDao.save(l1);

        Libri l2 = new Libri();
        l2.setTitolo("Le Due Torri");
        l2.setAnnoPubblicazione(1954);
        l2.setNumeroPagine(509);
        l2.setAutore("J.R.R. Tolkien");
        l2.setGenere("Fantasy");

       prodottoDao.save(l2);

        Libri l3 = new Libri();
        l3.setTitolo("Il Ritorno del Re");
        l3.setAnnoPubblicazione(1955);
        l3.setNumeroPagine(422);
        l3.setAutore("J.R.R. Tolkien");
        l3.setGenere("Fantasy");

        prodottoDao.save(l3);

        Libri l4 = new Libri();
        l4.setTitolo("Racconto di Due Città");
        l4.setAnnoPubblicazione(1859);
        l4.setNumeroPagine(462);
        l4.setAutore("Charles Dickens");
        l4.setGenere("Romanzo storico");

        prodottoDao.save(l4);

        Riviste r1 = new Riviste();
        r1.setTitolo("Settimana Enigmistica");
        r1.setAnnoPubblicazione(2024);
        r1.setNumeroPagine(46);
        r1.setPeriodico(Periodico.SETTIMANALE);

        prodottoDao.save(r1);

        Riviste r2 = new Riviste();
        r2.setTitolo("Focus");
        r2.setAnnoPubblicazione(2024);
        r2.setNumeroPagine(82);
        r2.setPeriodico(Periodico.MENSILE);

        prodottoDao.save(r2);


        Utente u1 = new Utente();
        u1.setNome("Mario");
        u1.setCognome("Rossi");
        u1.setDataNascita(LocalDate.of(1959,4,6));

        utenteDao.save(u1);

        Utente u2 = new Utente();
        u2.setNome("Luigi");
        u2.setCognome("Verdi");
        u2.setDataNascita(LocalDate.of(1998,5,14));

        utenteDao.save(u2);

        Utente u3 = new Utente();
        u3.setNome("Elena");
        u3.setCognome("Bianchi");
        u3.setDataNascita(LocalDate.of(1975,11,21));

        utenteDao.save(u3);


        Prestito p1 = new Prestito();
        p1.setUtente(u1);
        p1.setProdotto(l2);
        p1.setInizioPrestito(LocalDate.of(2024,3,1));
        p1.getRestituzionePrevista();
        p1.setRestituzioneEffettiva(LocalDate.of(2024, 4,1));

        prestitoDao.save(p1);

        Prestito p2 = new Prestito();
        p2.setUtente(u1);
        p2.setProdotto(l4);
        p2.setInizioPrestito(LocalDate.of(2024,2,3));
        p2.getRestituzionePrevista();

        prestitoDao.save(p2);

        Prestito p3 = new Prestito();
        p3.setUtente(u2);
        p3.setProdotto(r2);
        p3.setInizioPrestito(LocalDate.of(2024,4,15));
        p3.getRestituzionePrevista();
        p3.setRestituzioneEffettiva(LocalDate.of(2024, 4, 20));

        prestitoDao.save(p3);


        //rimozione di un elemento dal catalogo dato il codice isbn
        prodottoDao.delete(l1.getCodiceISBN());

        //ricerca dato il codice isbn
        //prodottoDao.getProdottoByIsbn(2).forEach(System.out::println);

        //ricerca per anno di pubblicazione
        //prodottoDao.getProdottoByAnno();

        //ricerca per autore
        //libriDao.getLibroByAutore();

        //ricerca per titolo o parte di titolo
        //prodottoDao.getProdottoByPartTitolo();

        //ricerca elementi attualmente in prestito dato il numero di tessera utente
        //prestitoDao.getProdottoByNumTessera();

        //ricerca dei prestiti scaduti e non restituiti

    }
}
