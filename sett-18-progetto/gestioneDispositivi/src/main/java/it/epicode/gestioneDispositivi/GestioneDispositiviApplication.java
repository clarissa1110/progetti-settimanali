package it.epicode.gestioneDispositivi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestioneDispositiviApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneDispositiviApplication.class, args);
	}

//	per popolare il database:

//	dipendenti:
//	https://localhost:8080/api/dipendenti/
//	"username":
//	"nome":
//	"cognome":
//	"email":
//
//	"avatar": -> patch
//
//
//	smartphone:
//	https://localhost:8080/api/smartphones/
//	"stato": (DISPONIBILE, ASSEGNATO, MANUTENZIONE, DISMESSO)
//	"dipendenteId": (int)
//	"marca":
//	"nome":
//
//
//	laptop:
//	https://localhost:8080/api/laptops/
//	"stato": (DISPONIBILE, ASSEGNATO, MANUTENZIONE, DISMESSO)
//	"dipendenteId":
//	"marca":
//	"nome":
}
