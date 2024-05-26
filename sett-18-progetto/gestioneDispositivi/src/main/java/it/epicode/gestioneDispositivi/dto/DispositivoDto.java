package it.epicode.gestioneDispositivi.dto;

import it.epicode.gestioneDispositivi.enums.Stato;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DispositivoDto {
    @NotNull(message = "il campo stato non può essere null")
    private Stato stato;

    @NotNull
    private int dipendenteId;
}
