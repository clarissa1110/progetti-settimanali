package it.epicode.gestioneDispositivi.services;

import it.epicode.gestioneDispositivi.dto.LaptopDto;
import it.epicode.gestioneDispositivi.dto.SmartphoneDto;
import it.epicode.gestioneDispositivi.exceptions.DipendenteNotFoundException;
import it.epicode.gestioneDispositivi.exceptions.DispositivoNotFoundException;
import it.epicode.gestioneDispositivi.models.Dipendente;
import it.epicode.gestioneDispositivi.models.Dispositivo;
import it.epicode.gestioneDispositivi.models.Laptop;
import it.epicode.gestioneDispositivi.models.Smartphone;
import it.epicode.gestioneDispositivi.repositories.DipendenteRepository;
import it.epicode.gestioneDispositivi.repositories.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public String saveSmartphone(SmartphoneDto smartphoneDto){
        Smartphone smartphone = new Smartphone();

        smartphone.setStato(smartphoneDto.getStato());
        smartphone.setMarca(smartphoneDto.getMarca());
        smartphone.setNome(smartphoneDto.getNome());

        Optional<Dipendente> dipendenteOp = dipendenteRepository.findById(smartphoneDto.getDipendenteId());

        if (dipendenteOp.isPresent()){
            Dipendente dipendente = dipendenteOp.get();
            smartphone.setDipendente(dipendente);

            smartphoneRepository.save(smartphone);

            return "Dispositivo smartphone con id = " + smartphone.getId() + " salvato correttamente";
        }
        else {
            throw new DipendenteNotFoundException("Dipendente con id = " + smartphoneDto.getDipendenteId() + " non trovato");
        }
    }

    public List<Dispositivo> getSmartphone(){
        return smartphoneRepository.findAll();
    }

    public Optional<Dispositivo> getSmartphoneById(int id){
        return smartphoneRepository.findById(id);
    }

    public Smartphone updateSmartphone(int id, SmartphoneDto smartphoneDto){
        Optional<Dispositivo> smartphoneOp = getSmartphoneById(id);

        if (smartphoneOp.isPresent()){
            Smartphone smartphone = (Smartphone) smartphoneOp.get();

            smartphone.setStato(smartphoneDto.getStato());
            smartphone.setMarca(smartphoneDto.getMarca());
            smartphone.setNome(smartphoneDto.getNome());

            Optional<Dipendente> dipendenteOp = dipendenteRepository.findById(smartphoneDto.getDipendenteId());

            if (dipendenteOp.isPresent()){
                Dipendente dipendente = dipendenteOp.get();
                smartphone.setDipendente(dipendente);
                smartphoneRepository.save(smartphone);

                return smartphone;
            }
            else {
                throw new DipendenteNotFoundException("Dipendente con id = " + smartphoneDto.getDipendenteId() + " non trovato");
            }
        }
        else {
            throw new DispositivoNotFoundException("Dispositivo smartphone con id = " + id + " non trovato");
        }
    }

    public String deleteSmartphone(int id){
        Optional<Dispositivo> smartphoneOp = getSmartphoneById(id);

        if (smartphoneOp.isPresent()){
            smartphoneRepository.delete(smartphoneOp.get());
            return "Dispositivo smartphone con id = " + id + " eliminato correttamente";
        }
        else {
            throw new DispositivoNotFoundException("Dispositivo smartphone con id = " + id + " non trovato");
        }
    }
}
