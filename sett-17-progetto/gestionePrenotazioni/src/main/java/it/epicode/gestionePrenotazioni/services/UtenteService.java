package it.epicode.gestionePrenotazioni.services;

import it.epicode.gestionePrenotazioni.beans.Edificio;
import it.epicode.gestionePrenotazioni.beans.Utente;
import it.epicode.gestionePrenotazioni.repositories.EdificioRepository;
import it.epicode.gestionePrenotazioni.repositories.PostazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.PrenotazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;


    public void saveUtente(Utente utente){
        utenteRepository.save(utente);
    }

    public Optional<Utente> findUtenteByUsername(String username){
       return utenteRepository.findById(username);
    }

}
