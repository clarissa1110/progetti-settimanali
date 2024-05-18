package it.epicode.gestionePrenotazioni.services;

import it.epicode.gestionePrenotazioni.beans.Edificio;
import it.epicode.gestionePrenotazioni.repositories.EdificioRepository;
import it.epicode.gestionePrenotazioni.repositories.PostazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.PrenotazioneRepository;
import it.epicode.gestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

//    @Autowired
//    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public void saveEdificio(Edificio edificio){
        edificioRepository.save(edificio);
    }
}
