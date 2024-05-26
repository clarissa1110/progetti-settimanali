package it.epicode.gestioneDispositivi.controllers;

import it.epicode.gestioneDispositivi.dto.SmartphoneDto;
import it.epicode.gestioneDispositivi.exceptions.BadRequestException;
import it.epicode.gestioneDispositivi.exceptions.DispositivoNotFoundException;
import it.epicode.gestioneDispositivi.models.Dispositivo;
import it.epicode.gestioneDispositivi.models.Smartphone;
import it.epicode.gestioneDispositivi.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @PostMapping("/smartphones")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveSmartphone(@RequestBody @Validated SmartphoneDto smartphoneDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", ((s, s2) -> s + s2)));
        }
        return smartphoneService.saveSmartphone(smartphoneDto);
    }

    @GetMapping("/smartphones")
    public List<Dispositivo> getSmartphones(){
        return smartphoneService.getSmartphone();
    }

    @GetMapping("/smartphones/{id}")
    public Smartphone getSmartphoneById(@PathVariable int id){
        Optional<Dispositivo> smartphoneOp = smartphoneService.getSmartphoneById(id);

        if (smartphoneOp.isPresent()){
            return (Smartphone) smartphoneOp.get();
        }
        else {
            throw new DispositivoNotFoundException("Dispositivo smartphone con id = " + id + " non trovato");
        }
    }

    @PutMapping("/smartphones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Smartphone updateSmartphone(@PathVariable int id, @RequestBody @Validated SmartphoneDto smartphoneDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", ((s, s2) -> s + s2)));
        }
        return smartphoneService.updateSmartphone(id, smartphoneDto);
    }

    @DeleteMapping("/smartphones/{id}")
    public String deleteSmartphone(@PathVariable int id){
        return smartphoneService.deleteSmartphone(id);
    }
}
