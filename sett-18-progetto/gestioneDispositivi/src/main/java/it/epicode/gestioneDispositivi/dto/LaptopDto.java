package it.epicode.gestioneDispositivi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LaptopDto extends DispositivoDto{
    @NotNull(message = "il campo marca non può essere vuoto")
    private String marca;
    private String nome;
}
