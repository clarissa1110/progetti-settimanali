package it.epicode.gestioneDispositivi.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
public class Laptop extends Dispositivo{
    private String marca;
    private String nome;
}
