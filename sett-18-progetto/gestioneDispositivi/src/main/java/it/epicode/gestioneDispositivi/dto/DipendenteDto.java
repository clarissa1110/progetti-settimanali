package it.epicode.gestioneDispositivi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteDto {

    @NotBlank(message = "il campo username non può essere vuoto")
    private String username;

    @NotBlank(message = "il campo nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "il campo cognome non può essere vuoto")
    private String cognome;

    @Email
    @NotBlank(message = "il campo email non può essere vuoto")
    private String email;
}
