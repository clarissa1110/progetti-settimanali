/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Se sei in difficoltà puoi chiedere aiuto a un Teaching Assistant
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per farlo puoi utilizzare il terminale Bash, quello di VSCode o quello del tuo sistema operativo (se utilizzi macOS o Linux)
*/

// JS Basics

/* ESERCIZIO A
  Crea una variabile chiamata "sum" e assegnaci il risultato della somma tra i valori 10 e 20.
*/
console.log('***JS Basics - ESERCIZIO A***');
let sum = 10 + 20;
console.log(sum);



/* ESERCIZIO B
  Crea una variabile chiamata "random" e assegnaci un numero casuale tra 0 e 20 (deve essere generato dinamicamente a ogni esecuzione).
*/
console.log('***JS Basics - ESERCIZIO B***');
let random = Math.floor(Math.random() * 21);
console.log(random);



/* ESERCIZIO C
  Crea una variabile chiamata "me" e assegnaci un oggetto contenente le seguenti proprietà: name = il tuo nome, surname = il tuo cognome, age = la tua età.
*/
console.log('***JS Basics - ESERCIZIO C***');
let me = {
  name: 'Clarissa',
  surname: 'Piovesan',
  age: 26
}
console.log(me);



/* ESERCIZIO D
  Crea del codice per rimuovere programmaticamente la proprietà "age" dall'oggetto precedentemente creato.
*/
console.log('***JS Basics - ESERCIZIO D***');
delete me.age
console.log(me);



/* ESERCIZIO E
  Crea del codice per aggiungere programmaticamente all'oggetto precedentemente creato un array chiamato "skills", contenente i linguaggi di programmazione che conosci.
*/
console.log('***JS Basics - ESERCIZIO E***');
me.skills = ["html", "css"]
console.log(me);



/* ESERCIZIO F
  Crea un pezzo di codice per aggiungere un nuovo elemento all'array "skills" contenuto nell'oggetto "me".
*/
console.log('***JS Basics - ESERCIZIO F***');
me.skills.push("javascript");
console.log(me);



/* ESERCIZIO G
  Crea un pezzo di codice per rimuovere programmaticamente l'ultimo elemento dall'array "skills" contenuto nell'oggetto "me".
*/
console.log('***JS Basics - ESERCIZIO G***');
me.skills.pop();
console.log(me);



// Funzioni

/* ESERCIZIO 1
  Crea una funzione chiamata "dice": deve generare un numero casuale tra 1 e 6.
*/
console.log('***FUNZIONI - ESERCIZIO 1***');
let numero = 0;
function dice(numero) {
  numero = Math.floor(Math.random() * 6 + 1);
  return numero;
}
console.log(dice(numero));



/* ESERCIZIO 2
  Crea una funzione chiamata "whoIsBigger" che riceve due numeri come parametri e ritorna il maggiore dei due.
*/
console.log('***FUNZIONI - ESERCIZIO 2***');
function whoIsBigger(num1, num2) {
  if (num1 > num2) {
    return num1;
  } else if (num1 < num2) {
    return num2;
  } else {
    return 'i due numeri sono uguali';
  }
}
console.log(whoIsBigger(5, 5))



/* ESERCIZIO 3
  Crea una funzione chiamata "splitMe" che riceve una stringa come parametro e ritorna un'array contenente ogni parola della stringa.

  Es.: splitMe("I love coding") => ritorna ["I", "Love", "Coding"]
*/
console.log('***FUNZIONI - ESERCIZIO 3***');
function splitMe(stringa) {
  return stringa.split(' ');
}
console.log(splitMe('I love coding'));



/* ESERCIZIO 4
  Crea una funzione chiamata "deleteOne" che riceve una stringa e un booleano come parametri.
  Se il valore booleano è true la funzione deve ritornare la stringa senza il primo carattere, altrimenti la deve ritornare senza l'ultimo.
*/
console.log('***FUNZIONI - ESERCIZIO 4***');
function deleteOne(stringa, booleano) {
  if (booleano === true) {
    return stringa.slice(1);
  } else {
    return stringa.slice(0, -1);
  }
}
console.log(deleteOne('epicode', true));



/* ESERCIZIO 5
  Crea una funzione chiamata "onlyLetters" che riceve una stringa come parametro e la ritorna eliminando tutte le cifre numeriche.

  Es.: onlyLetters("I have 4 dogs") => ritorna "I have dogs"
*/
console.log('***FUNZIONI - ESERCIZIO 5***');
function onlyLetters(stringa) {
  const nuovaStringa = stringa.replace(/[0-9]/, '');
  return nuovaStringa;
}
console.log(onlyLetters('I have 4 dogs'));



/* ESERCIZIO 6
  Crea una funzione chiamata "isThisAnEmail" che riceve una stringa come parametro e ritorna true se la stringa è un valido indirizzo email.
*/
console.log('***FUNZIONI - ESERCIZIO 6***');
function isThisAnEmail(stringa) {
  const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  if (regexEmail.test(stringa)) {
    return true;
  } else {
    return false;
  }
}
console.log(isThisAnEmail('clarissapiovesan@gmail.com'));



/* ESERCIZIO 7
  Scrivi una funzione chiamata "whatDayIsIt" che ritorna il giorno della settimana corrente.
*/
console.log('***FUNZIONI - ESERCIZIO 7***');
function whatDayIsIt() {
  const data = new Date().getDay();
  let dayOfTheWeek;
  switch (data) {
    case 0: dayOfTheWeek = 'Domenica';
      break;
    case 1: dayOfTheWeek = 'Lunedì';
      break;
    case 2: dayOfTheWeek = 'Martedì';
      break;
    case 3: dayOfTheWeek = 'Mercoledì';
      break;
    case 4: dayOfTheWeek = 'Giovedì';
      break;
    case 5: dayOfTheWeek = 'Venerdì';
      break;
    case 6: dayOfTheWeek = 'Sabato';
  }
  return dayOfTheWeek;
}
console.log(whatDayIsIt());



/* ESERCIZIO 8
  Scrivi una funzione chiamata "rollTheDices" che riceve un numero come parametro.
  Deve invocare la precedente funzione dice() il numero di volte specificato nel parametro, e deve tornare un oggetto contenente una proprietà "sum":
  il suo valore deve rappresentare il totale di tutti i valori estratti con le invocazioni di dice().
  L'oggetto ritornato deve anche contenere una proprietà "values", contenente un array con tutti i valori estratti dalle invocazioni di dice().

  Example:
  rollTheDices(3) => ritorna {
      sum: 10
      values: [3, 3, 4]
  }
*/
console.log('***FUNZIONI - ESERCIZIO 8   SBAGLIATO***');
/*
function rollTheDices(num) {

  dice(num);

  const numeriEstratti = [];

  //ogni volta che viene estratto un numero -> numeriEstratti.push
  for (let i = 0; i < numeriEstratti.length; i++) {
    numeriEstratti.push(numero);
  }

  const numeroSomma = numeriEstratti.reduce((totale, valoreCorrente) => totale + valoreCorrente);

  const oggetto = {
    sum: numeroSomma,
    values: [numeriEstratti]
  }

  return oggetto;
}
console.log(rollTheDices(2));
*/



/* ESERCIZIO 9
  Scrivi una funzione chiamata "howManyDays" che riceve una data come parametro e ritorna il numero di giorni trascorsi da tale data.
*/
console.log('***FUNZIONI - ESERCIZIO 9***');
function howManyDays(data) {
  const dataMillisec = new Date(data).getTime();

  const dataOggi = new Date();
  const oggiMillisec = dataOggi.getTime();

  const differenzaMillisec = oggiMillisec - dataMillisec;

  const differenzaGiorni = Math.floor(differenzaMillisec / (1000 * 60 * 60 * 24));

  return differenzaGiorni;
}
console.log(howManyDays('2024-02-1'));


/* ESERCIZIO 10
  Scrivi una funzione chiamata "isTodayMyBirthday" che deve ritornare true se oggi è il tuo compleanno, falso negli altri casi.
*/
console.log('***FUNZIONI - ESERCIZIO 10***');
function isTodayMyBirthday() {
  const myBirthday = new Date(9, 11);
  const dataOggi = new Date();

  if (dataOggi === myBirthday) {
    return true;
  } else {
    return false;
  }
}
console.log(isTodayMyBirthday());


// Arrays & Oggetti

// NOTA: l'array "movies" usato in alcuni esercizi è definito alla fine di questo file

/* Questo array viene usato per gli esercizi. Non modificarlo. */

const movies = [
  {
    Title: 'The Lord of the Rings: The Fellowship of the Ring',
    Year: '2001',
    imdbID: 'tt0120737',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg',
  },

  {
    Title: 'The Lord of the Rings: The Return of the King',
    Year: '2003',
    imdbID: 'tt0167260',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings: The Two Towers',
    Year: '2002',
    imdbID: 'tt0167261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of War',
    Year: '2005',
    imdbID: 'tt0399295',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTYzZWE3MDAtZjZkMi00MzhlLTlhZDUtNmI2Zjg3OWVlZWI0XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'Lords of Dogtown',
    Year: '2005',
    imdbID: 'tt0355702',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDBhNGJlOTAtM2ExNi00NmEzLWFmZTQtYTZhYTRlNjJjODhmXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings',
    Year: '1978',
    imdbID: 'tt0077869',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGMyNWJhZmYtNGQxYi00Y2ZjLWJmNjktNTgzZWJjOTg4YjM3L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1990',
    imdbID: 'tt0100054',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOTI2NTQyODk0M15BMl5BanBnXkFtZTcwNTQ3NDk0NA@@._V1_SX300.jpg',
  },
  {
    Title: 'The Lords of Salem',
    Year: '2012',
    imdbID: 'tt1731697',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjA2NTc5Njc4MV5BMl5BanBnXkFtZTcwNTYzMTcwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Greystoke: The Legend of Tarzan, Lord of the Apes',
    Year: '1984',
    imdbID: 'tt0087365',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM5MzcwOTg4MF5BMl5BanBnXkFtZTgwOTQwMzQxMDE@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1963',
    imdbID: 'tt0057261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGEwYTlhMTgtODBlNC00ZjgzLTk1ZmEtNmNkMTEwYTZiM2Y0XkEyXkFqcGdeQXVyMzU4Nzk4MDI@._V1_SX300.jpg',
  },
  {
    Title: 'The Avengers',
    Year: '2012',
    imdbID: 'tt0848228',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Infinity War',
    Year: '2018',
    imdbID: 'tt4154756',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Age of Ultron',
    Year: '2015',
    imdbID: 'tt2395427',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Endgame',
    Year: '2019',
    imdbID: 'tt4154796',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg',
  },
]

/* ESERCIZIO 11
  Scrivi una funzione chiamata "deleteProp" che riceve un oggetto e una stringa come parametri; deve ritornare l'oggetto fornito dopo aver eliminato
  in esso la proprietà chiamata come la stringa passata come secondo parametro.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 11***');
function deleteProp(oggetto, stringa) {
  delete oggetto[stringa];
  return oggetto
}
console.log(deleteProp(movies[0], 'Type'));



/* ESERCIZIO 12
  Scrivi una funzione chiamata "newestMovie" che trova il film più recente nell'array "movies" fornito.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 12***');
function newestMovie() {
  let anno = 1900;
  movies.forEach((element) => {
    if (Number(element.Year) > anno) {
      anno = Number(element.Year);
    }
  })
  return anno;
}
console.log(newestMovie());



/* ESERCIZIO 13
  Scrivi una funzione chiamata countMovies che ritorna il numero di film contenuti nell'array "movies" fornito.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 13***');
function countMovies(array) {
  return array.length;
}
console.log(countMovies(movies));



/* ESERCIZIO 14
  Scrivi una funzione chiamata "onlyTheYears" che crea un array con solamente gli anni di uscita dei film contenuti nell'array "movies" fornito.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 14***');
function onlyTheYears() {
  return movies.map((element) => element.Year);
}
console.log(onlyTheYears());



/* ESERCIZIO 15
  Scrivi una funzione chiamata "onlyInLastMillennium" che ritorna solamente i film prodotto nel millennio scorso contenuti nell'array "movies" fornito.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 15***');
function onlyInLastMillennium() {
  return movies.filter((element) => Number(element.Year) < 2000);

}
console.log(onlyInLastMillennium());



/* ESERCIZIO 16
  Scrivi una funzione chiamata "sumAllTheYears" che ritorna la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array "movies" fornito.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 16***');
function sumAllTheYears() {
  return movies.reduce((totale, valoreCorrente) => Number(totale.Year) + Number(valoreCorrente.Year));
}
console.log(sumAllTheYears(movies));



/* ESERCIZIO 17
  Scrivi una funzione chiamata "searchByTitle" che riceve una stringa come parametro e ritorna i film nell'array "movies" fornito che la contengono nel titolo.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 17***');
function searchByTitle(stringa) {
  return movies.filter((element) => element.Title.includes(stringa));
}
console.log(searchByTitle('Lord'));



/* ESERCIZIO 18
  Scrivi una funzione chiamata "searchAndDivide" che riceve una stringa come parametro e ritorna un oggetto contenente due array: "match" e "unmatch".
  "match" deve includere tutti i film dell'array "movies" fornito che contengono la stringa fornita all'interno del proprio titolo, mentre "unmatch" deve includere tutti i rimanenti.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 18***');
function searchAndDivide(stringa) {
  const confronta = {
    match: [],
    unmatch: []
  }

  for (let i = 0; i < movies.length; i++) {

    if (movies[i].Title.includes(stringa)) {
      confronta.match.push(movies[i]);
    } else {
      confronta.unmatch.push(movies[i]);
    }
  }
  return confronta;
}
console.log(searchAndDivide('Avengers'));



/* ESERCIZIO 19
  Scrivi una funzione chiamata "removeIndex" che riceve un numero come parametro e ritorna l'array "movies" fornito privo dell'elemento nella posizione ricevuta come parametro.
*/
console.log('***ARRAY E OGGETTI - ESERCIZIO 19***');
function removeIndex(num) {
  const nuovoMovies = movies.splice(num, 1);
  return movies;
}
console.log(removeIndex(2));


// DOM (nota: gli elementi che selezionerai non si trovano realmente nella pagina)

/* ESERCIZIO 20
  Scrivi una funzione per selezionare l'elemento dotato di id "container" all'interno della pagina.
*/
console.log('***DOM - ESERCIZIO 20***');
document.getElementById('container');



/* ESERCIZIO 21
  Scrivi una funzione per selezionare ogni tag <td> all'interno della pagina.
*/
console.log('***DOM - ESERCIZIO 21***');
document.getElementsByTagName('td');



/* ESERCIZIO 22
  Scrivi una funzione che, tramite un ciclo, stampa in console il testo contenuto in ogni tag <td> all'interno della pagina.
*/
console.log('***DOM - ESERCIZIO 22***');
function stampaTd() {
  const testoTd = document.getElementsByTagName('td');
  for (let i = 0; i < testoTd.length; i++) {
    console.log(testoTd[i].innerText);
  }
}
stampaTd();



/* ESERCIZIO 23
  Scrivi una funzione per aggiungere un background di colore rosso a ogni link all'interno della pagina.
*/
console.log('***DOM - ESERCIZIO 23***');
function sfondo() {
  const sfondoRosso = document.getElementsByTagName('a');

  for (let i = 0; i < sfondoRosso.length; i++) {
    sfondoRosso[i].style.backgroundColor = 'red';
  }
}
sfondo();



/* ESERCIZIO 24
  Scrivi una funzione per aggiungere un nuovo elemento alla lista non ordinata con id "myList".
*/
console.log('***DOM - ESERCIZIO 24***');

let lista = document.getElementById('myList');

function addLi() {
  let newLi = document.createElement('li');
  newLi.innerText = 'nuovo elemento lista';


  lista.appendChild(newLi);
}
addLi();



/* ESERCIZIO 25
  Scrivi una funzione per svuotare la lista non ordinata con id "myList".
*/
console.log('***DOM - ESERCIZIO 25***');
/*
function svuotaLista() {
  lista.innerText = '';
}
svuotaLista();
*/



/* ESERCIZIO 26
  Scrivi una funzione per aggiungere ad ogni tag <tr> la classe CSS "test"
*/
console.log('***DOM - ESERCIZIO 26***');
function addClass() {
  const tagTr = document.getElementsByTagName('tr');

  for (let i = 0; i < tagTr.length; i++) {
    tagTr[i].classList.add('test');
  }
}
addClass();



// [EXTRA] JS Avanzato

/* ESERCIZIO 27
  Crea una funzione chiamata "halfTree" che riceve un numero come parametro e costruisce un mezzo albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  halfTree(3)

  *
  **
  ***

*/

/* ESERCIZIO 28
  Crea una funzione chiamata "tree" che riceve un numero come parametro e costruisce un albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  tree(3)

    *
   ***
  *****

*/

/* ESERCIZIO 29
  Crea una funzione chiamata "isItPrime" che riceve un numero come parametro e ritorna true se il numero fornito è un numero primo.
*/

