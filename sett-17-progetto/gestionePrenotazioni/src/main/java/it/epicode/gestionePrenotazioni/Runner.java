package it.epicode.gestionePrenotazioni;

import it.epicode.gestionePrenotazioni.beans.Edificio;
import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;
import it.epicode.gestionePrenotazioni.beans.Utente;
import it.epicode.gestionePrenotazioni.enums.TipoPostazione;
import it.epicode.gestionePrenotazioni.services.EdificioService;
import it.epicode.gestionePrenotazioni.services.PostazioneService;
import it.epicode.gestionePrenotazioni.services.PrenotazioneService;
import it.epicode.gestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);

//        Edificio edificio1 = ctx.getBean("edificio1", Edificio.class);
//        edificioService.saveEdificio(edificio1);
//
//        Edificio edificio2 = ctx.getBean("edificio2", Edificio.class);
//        edificioService.saveEdificio(edificio2);
//
//        Edificio edificio3 = ctx.getBean("edificio3", Edificio.class);
//        edificioService.saveEdificio(edificio3);
//
//        Postazione postazione1 = ctx.getBean("postazione1", Postazione.class);
//        postazioneService.savePostazione(postazione1);
//
//        Postazione postazione2 = ctx.getBean("postazione2", Postazione.class);
//        postazioneService.savePostazione(postazione2);
//
//        Postazione postazione3 = ctx.getBean("postazione3", Postazione.class);
//        postazioneService.savePostazione(postazione3);
//
//        Utente utente1 = ctx.getBean("utente1", Utente.class);
//        utenteService.saveUtente(utente1);
//
//        Utente utente2 = ctx.getBean("utente2", Utente.class);
//        utenteService.saveUtente(utente2);
//
//        Prenotazione prenotazione1 = ctx.getBean("prenotazione1", Prenotazione.class);
//        prenotazioneService.savePrenotazione(prenotazione1);
//
//        Prenotazione prenotazione2 = ctx.getBean("prenotazione2", Prenotazione.class);
//        prenotazioneService.savePrenotazione(prenotazione2);
//
//        Prenotazione prenotazione3 = ctx.getBean("prenotazione3", Prenotazione.class);
//        prenotazioneService.savePrenotazione(prenotazione3);




        System.out.println(postazioneService.ricercaPostazioniPerTipoECitta(TipoPostazione.SALA_RIUNIONI, "Milano"));
        System.out.println(prenotazioneService.ricercaPerUtenteEData("mario10", LocalDate.now()));
        //System.out.println(prenotazioneService.ricercaPerPostazioneEData());
    }
}
