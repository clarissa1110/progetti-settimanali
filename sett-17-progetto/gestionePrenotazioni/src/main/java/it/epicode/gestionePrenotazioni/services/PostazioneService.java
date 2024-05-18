package it.epicode.gestionePrenotazioni.services;

import it.epicode.gestionePrenotazioni.beans.Edificio;
import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;
import it.epicode.gestionePrenotazioni.beans.Utente;
import it.epicode.gestionePrenotazioni.enums.TipoPostazione;
import it.epicode.gestionePrenotazioni.repositories.EdificioRepository;
import it.epicode.gestionePrenotazioni.repositories.PostazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.PrenotazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {
    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;


    public void savePostazione(Postazione postazione){
        postazioneRepository.save(postazione);
    }

    public Optional<Postazione> findPostazioneById(int postazioneId){
        return postazioneRepository.findById(postazioneId);
    }

    public List<Postazione> ricercaPostazioniPerTipoECitta(TipoPostazione tipoPostazione, String citta){
        return postazioneRepository.ricercaPostazioniPerTipoECitta(tipoPostazione, citta);
    }
}
