# Progetto settimanale - settimana 11 - Angular

Al caricamento della pagina viene visualizzata la pagina di accoglienza, dalla quale si può registrare un nuovo utente o accedere all'applicazione. 
Inizialmente le uniche pagine visibili sulla navbar sono quelle di login e registrazione.

Dopo l'accesso, la navbar presenta le sezioni "Home", "All Movies", "Users" e il menu "Profile". Sulla pagina "All Movies" vengono presentate le card di tutti i film. Cliccando sul titolo si viene reindirizzati sulla pagina che contiene i dettagli del film scelto. 

La pagina "Users" mostra le informazioni di tutti gli utenti registrati. 

Al logout si viene reindirizzati alla pagina di login, il token viene cancellato dal local storage e le altre pagine non sono più accessibili neanche ricercandole manualmente tramite url. 

Purtroppo manca la pagina di dettagli dell'utente che ha fatto login, a causa di un problema che non ho saputo risolvere in user-profile.component.ts: richiamando la funzione getUser() dal service, non accetta l'id come parametro, anche se nel service è presente, e quindi non mi è permesso accedere ai dati dell'utente.

Allo stesso modo, manca tutto il meccanismo dei preferiti, perché nonostante molti tentativi non ho capito come far comunicare le informazioni dei film e degli utenti.