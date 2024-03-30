# Progetto settimanale - settimana 10 - Angular

Al caricamento della pagina, la prima sezione che si carica raccoglie tutti i task, sia quelli già eseguiti, sia quelli ancora da compiere. Cliccando sulla checkbox il task scompare e viene mandato nella pagina dei task completati - se era precedentemente incompiuto - e viceversa nella pagina dei task incompiuti se era inizialmente completato.

Lo stesso avviene nelle rispettive pagine "see how much we've accomplished" e "what's left"; il cambiamento avviene in tempo reale.

A causa di un problema che non sono stata in grado di risolvere nonostante i numerosi e diversi tentativi, non ho potuto "mettere in comunicazione" le due basi dati, quindi in ogni pagina la sezione "assigned to" del task presenta o il nome di un utente - sempre lo stesso - oppure l'id dell'utente piuttosto che il nome. 
Per lo stesso problema, nella pagina dedicata agli utenti sono riuscita a far ciclare e apparire ciascun utente, ma non i suoi task; questi tuttavia vengono mostrati ordinatamente in console, divisi in base all'utente, tramite il log di taskUser.