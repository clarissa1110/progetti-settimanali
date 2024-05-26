package it.epicode.gestioneDispositivi.services;

import it.epicode.gestioneDispositivi.dto.LaptopDto;
import it.epicode.gestioneDispositivi.exceptions.DipendenteNotFoundException;
import it.epicode.gestioneDispositivi.exceptions.DispositivoNotFoundException;
import it.epicode.gestioneDispositivi.models.Dipendente;
import it.epicode.gestioneDispositivi.models.Dispositivo;
import it.epicode.gestioneDispositivi.models.Laptop;
import it.epicode.gestioneDispositivi.repositories.DipendenteRepository;
import it.epicode.gestioneDispositivi.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public String saveLaptop(LaptopDto laptopDto){
        Laptop laptop = new Laptop();

        laptop.setStato(laptopDto.getStato());
        laptop.setMarca(laptopDto.getMarca());
        laptop.setNome(laptopDto.getNome());

        Optional<Dipendente> dipendenteOp = dipendenteRepository.findById(laptopDto.getDipendenteId());

        if (dipendenteOp.isPresent()){
            Dipendente dipendente = dipendenteOp.get();
            laptop.setDipendente(dipendente);

            laptopRepository.save(laptop);

            return "Dispositivo laptop con id = " + laptop.getId() + " salvato correttamente";
        }
        else {
            throw new DipendenteNotFoundException("Dipendente con id = " + laptopDto.getDipendenteId() + " non trovato");
        }
    }

    public List<Dispositivo> getLaptops(){
        return laptopRepository.findAll();
    }

    public Optional<Dispositivo> getLaptopById(int id){
        return laptopRepository.findById(id);
    }

    public Laptop updateLaptop(int id, LaptopDto laptopDto){
        Optional<Dispositivo> laptopOp = getLaptopById(id);

        if (laptopOp.isPresent()){
            Laptop laptop = (Laptop) laptopOp.get();

            laptop.setStato(laptopDto.getStato());
            laptop.setMarca(laptopDto.getMarca());
            laptop.setNome(laptopDto.getNome());

            Optional<Dipendente> dipendenteOp = dipendenteRepository.findById(laptopDto.getDipendenteId());

            if (dipendenteOp.isPresent()){
                Dipendente dipendente = dipendenteOp.get();
                laptop.setDipendente(dipendente);
                laptopRepository.save(laptop);

                return laptop;
            }
            else {
                throw new DipendenteNotFoundException("Dipendente con id = " + laptopDto.getDipendenteId() + " non trovato");
            }
        }
        else {
            throw new DispositivoNotFoundException("Dispositivo laptop con id = " + id + " non trovato");
        }
    }

    public String deleteLaptop(int id){
        Optional<Dispositivo> laptopOp = getLaptopById(id);

        if (laptopOp.isPresent()){
            laptopRepository.delete(laptopOp.get());
            return "Dispositivo laptop con id = " + id + " eliminato correttamente";
        }
        else {
            throw new DispositivoNotFoundException("Dispositivo laptop con id = " + id + " non trovato");
        }
    }
}
