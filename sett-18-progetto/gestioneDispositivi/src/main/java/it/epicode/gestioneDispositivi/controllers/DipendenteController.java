package it.epicode.gestioneDispositivi.controllers;

import it.epicode.gestioneDispositivi.dto.DipendenteDto;
import it.epicode.gestioneDispositivi.exceptions.BadRequestException;
import it.epicode.gestioneDispositivi.exceptions.DipendenteNotFoundException;
import it.epicode.gestioneDispositivi.models.Dipendente;
import it.epicode.gestioneDispositivi.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/dipendenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", ((s, s2) -> s + s2)));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @GetMapping("/dipendenti")
    public List<Dipendente> getDipendenti(){
        return dipendenteService.getDipendenti();
    }

    @GetMapping("/dipendenti/{id}")
    public Dipendente getDipendenteById(@PathVariable int id){
        Optional<Dipendente> dipendenteOp = dipendenteService.getDipendenteById(id);

        if (dipendenteOp.isPresent()){
            return dipendenteOp.get();
        }
        else {
            throw new DipendenteNotFoundException("Dipendente con id = " + id + " non trovato");
        }
    }

    @PutMapping("/dipendenti/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", ((s, s2) -> s + s2)));
        }
        return dipendenteService.updateDipendente(id, dipendenteDto);
    }

    @DeleteMapping("/dipendenti/{id}")
    public String deleteDipendente(@PathVariable int id){
        return dipendenteService.deleteDipendente(id);
    }

    @PatchMapping("/dipendenti/{id}")
    public String patchAvatarDipendente(@RequestBody MultipartFile avatar, @PathVariable int id) throws IOException {
        return dipendenteService.patchAvatarDipendente(id, avatar);
    }
}
