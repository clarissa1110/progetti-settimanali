package it.epicode.gestionePrenotazioni.services;

import it.epicode.gestionePrenotazioni.beans.Edificio;
import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;
import it.epicode.gestionePrenotazioni.beans.Utente;
import it.epicode.gestionePrenotazioni.repositories.EdificioRepository;
import it.epicode.gestionePrenotazioni.repositories.PostazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.PrenotazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;


    public void savePrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione nuovaPrenotazione(String username, int postazioneId, LocalDate dataPrenotazione) throws Exception {
        Utente utente = utenteRepository.findById(username).orElseThrow(()->new Exception("Utente non trovato."));

        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(()->new Exception("Postazione non disponibile."));

        if (!prenotazioneRepository.findByUtenteAndData(username, dataPrenotazione).isEmpty()){
            throw new Exception("Questo utente presenta già una prenotazione in questa data!");
        }

        if (prenotazioneRepository.findByPostazioneAndData(postazioneId, dataPrenotazione).size()>=postazione.getMaxOccupanti()) {
            throw new Exception("Non risultano posti disponibili nella data selezionata in questa postazione.");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(dataPrenotazione);

        //utente.getPrenotazioni().add(prenotazione);

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> ricercaPerPostazioneEData(int postazioneID, LocalDate dataPrenotazione){
       return prenotazioneRepository.findByPostazioneAndData(postazioneID, dataPrenotazione);
    }

    public List<Prenotazione> ricercaPerUtenteEData(String username, LocalDate dataPrenotazione){
        return prenotazioneRepository.findByUtenteAndData(username, dataPrenotazione);
    }
}
