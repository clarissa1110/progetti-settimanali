package it.epicode.gestioneDispositivi.exceptions;

public class DispositivoNotFoundException extends RuntimeException{
    public DispositivoNotFoundException(String message){
        super(message);
    }
}
