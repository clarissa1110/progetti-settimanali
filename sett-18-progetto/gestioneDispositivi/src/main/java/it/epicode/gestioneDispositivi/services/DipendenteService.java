package it.epicode.gestioneDispositivi.services;

import com.cloudinary.Cloudinary;
import it.epicode.gestioneDispositivi.dto.DipendenteDto;
import it.epicode.gestioneDispositivi.exceptions.DipendenteNotFoundException;
import it.epicode.gestioneDispositivi.models.Dipendente;
import it.epicode.gestioneDispositivi.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private Cloudinary cloudinary;

    public String saveDipendente(DipendenteDto dipendenteDto){
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());

        dipendenteRepository.save(dipendente);

        return "Dipendente con id = " + dipendente.getId() + " salvato correttamente";
    }

    public List<Dipendente> getDipendenti(){
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> getDipendenteById(int id){
        return dipendenteRepository.findById(id);
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto){
        Optional<Dipendente> dipendenteOp = getDipendenteById(id);

        if (dipendenteOp.isPresent()){
            Dipendente dipendente = dipendenteOp.get();
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setEmail(dipendenteDto.getEmail());
            dipendenteRepository.save(dipendente);

            return dipendente;
        }
        else {
            throw new DipendenteNotFoundException("Dipendente con id = " + id + " non trovato");
        }
    }

    public String deleteDipendente(int id){
        Optional<Dipendente> dipendenteOp = getDipendenteById(id);

        if (dipendenteOp.isPresent()){
            dipendenteRepository.delete(dipendenteOp.get());
            return "Dipendente con id = " + id + " eliminato correttamente";
        }
        else {
            throw new DipendenteNotFoundException("Dipendente con id = " + id + " non trovato");
        }
    }

    public String patchAvatarDipendente(int id, MultipartFile avatar) throws IOException {
        Optional<Dipendente> dipendenteOp = getDipendenteById(id);

        if (dipendenteOp.isPresent()){
            String url = (String) cloudinary.uploader().upload(avatar.getBytes(), Collections.emptyMap()).get("url");

            Dipendente dipendente = dipendenteOp.get();
            dipendente.setAvatar(url);
            dipendenteRepository.save(dipendente);
            return "Dipendente con id = " + id + " aggiornato correttamente";
        }
        else {
            throw new DipendenteNotFoundException("Dipendente con id = " + id + " non trovato");
        }
    }
}
