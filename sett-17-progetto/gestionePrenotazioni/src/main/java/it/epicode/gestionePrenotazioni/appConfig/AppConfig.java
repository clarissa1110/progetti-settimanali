package it.epicode.gestionePrenotazioni.appConfig;

import it.epicode.gestionePrenotazioni.beans.Edificio;
import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;
import it.epicode.gestionePrenotazioni.beans.Utente;
import it.epicode.gestionePrenotazioni.enums.TipoPostazione;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.ArrayList;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean("edificio1")
    public Edificio edificio1(){
        Edificio edificio1 = new Edificio();
        edificio1.setNome("Edificio 1");
        edificio1.setIndirizzo("Via Roma 2");
        edificio1.setCitta("Milano");
        return edificio1;
    }

    @Bean("edificio2")
    public Edificio edificio2(){
        Edificio edificio2 = new Edificio();
        edificio2.setNome("Edificio 2");
        edificio2.setIndirizzo("Via Venezia 13");
        edificio2.setCitta("Roma");

        return edificio2;
    }

    @Bean("edificio3")
    public Edificio edificio3(){
        Edificio edificio3 = new Edificio();
        edificio3.setNome("Edificio 3");
        edificio3.setIndirizzo("Via Milano 5");
        edificio3.setCitta("Venezia");

        return edificio3;
    }

    @Bean("postazione1")
    public Postazione postazione1(){
        Postazione postazione1 = new Postazione();
        postazione1.setDescrizione("Postazione 1");
        postazione1.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazione1.setMaxOccupanti(15);
        postazione1.setEdificio(edificio1());

        return postazione1;
    }

    @Bean("postazione2")
    public Postazione postazione2(){
        Postazione postazione2 = new Postazione();
        postazione2.setDescrizione("Postazione 2");
        postazione2.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione2.setMaxOccupanti(7);
        postazione2.setEdificio(edificio2());

        return postazione2;
    }

    @Bean("postazione3")
    public Postazione postazione3(){
        Postazione postazione3 = new Postazione();
        postazione3.setDescrizione("Postazione 3");
        postazione3.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione3.setMaxOccupanti(24);
        postazione3.setEdificio(edificio3());

        return postazione3;
    }

    @Bean("prenotazione1")
    public Prenotazione prenotazione1(){
        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setDataPrenotazione(LocalDate.now());
        prenotazione1.setPostazione(postazione1());
        prenotazione1.setUtente(utente1());

        return prenotazione1;
    }

    @Bean("prenotazione2")
    public Prenotazione prenotazione2(){
        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setDataPrenotazione(LocalDate.of(2024,5,19));
        prenotazione2.setPostazione(postazione2());
        prenotazione2.setUtente(utente1());

        return prenotazione2;
    }

    @Bean("prenotazione3")
    public Prenotazione prenotazione3(){
        Prenotazione prenotazione3 = new Prenotazione();
        prenotazione3.setDataPrenotazione(LocalDate.of(2024,5,19));
        prenotazione3.setPostazione(postazione3());
        prenotazione3.setUtente(utente2());

        return prenotazione3;
    }

    public Utente utente0(){
        Utente utente0 = new Utente();
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        utente0.setPrenotazioni(prenotazioni);

        return utente0;
    }

    @Bean("utente1")
    public Utente utente1(){
        Utente utente1 = utente0();
        utente1.setUsername("mario10");
        utente1.setNomeCognome("Mario Rossi");
        utente1.setEmail("mario@rossi.com");
//        utente1.getPrenotazioni().add(prenotazione1());
//        utente1.getPrenotazioni().add(prenotazione2());

        return utente1;
    }

    @Bean("utente2")
    public Utente utente2(){
        Utente utente2 = utente0();
        utente2.setUsername("giulia123");
        utente2.setNomeCognome("Giulia Verdi");
        utente2.setEmail("giulia@verdi.com");

        return utente2;
    }
}
