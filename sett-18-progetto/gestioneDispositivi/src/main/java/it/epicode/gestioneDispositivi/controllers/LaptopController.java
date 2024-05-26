package it.epicode.gestioneDispositivi.controllers;

import it.epicode.gestioneDispositivi.dto.LaptopDto;
import it.epicode.gestioneDispositivi.exceptions.BadRequestException;
import it.epicode.gestioneDispositivi.exceptions.DispositivoNotFoundException;
import it.epicode.gestioneDispositivi.models.Dispositivo;
import it.epicode.gestioneDispositivi.models.Laptop;
import it.epicode.gestioneDispositivi.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/laptops")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveLaptop(@RequestBody @Validated LaptopDto laptopDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", ((s, s2) -> s + s2)));
        }
        return laptopService.saveLaptop(laptopDto);
    }

    @GetMapping("/laptops")
    public List<Dispositivo> getLaptops(){
        return laptopService.getLaptops();
    }

    @GetMapping("/laptops/{id}")
    public Laptop getLaptopById(@PathVariable int id){
        Optional<Dispositivo> laptopOp = laptopService.getLaptopById(id);

        if (laptopOp.isPresent()){
            return (Laptop) laptopOp.get();
        }
        else {
            throw new DispositivoNotFoundException("Dispositivo laptop con id = " + id + " non trovato");
        }
    }

    @PutMapping("/laptops/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Laptop updateLaptop(@PathVariable int id, @RequestBody @Validated LaptopDto laptopDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", ((s, s2) -> s + s2)));
        }
        return laptopService.updateLaptop(id, laptopDto);
    }

    @DeleteMapping("/laptops/{id}")
    public String deleteLaptop(@PathVariable int id){
        return laptopService.deleteLaptop(id);
    }

}
