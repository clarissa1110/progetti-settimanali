/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
/*
const pets = ['dog', 'cat', 'hamster', 'redfish']
console.log(pets[0]);
console.log(pets[1]);
console.log(pets[2]);
console.log(pets[3]);
*/



/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/
//const sortedPets = pets.sort();



/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/
//console.log(sortedPets);



/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/
/*
pets.shift();
pets.push('dog');
console.log(pets);
*/



/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/
const cars = [
  {
    brand: 'Ford',
    model: 'Fiesta',
    color: 'red',
    trims: ['titanium', 'st', 'active'],
  },
  {
    brand: 'Peugeot',
    model: '208',
    color: 'blue',
    trims: ['allure', 'GT'],
  },
  {
    brand: 'Volkswagen',
    model: 'Polo',
    color: 'black',
    trims: ['life', 'style', 'r-line'],
  },
]

cars[0].licensePlate = "AB123CD"
cars[1].licensePlate = "EF456GH"
cars[2].licensePlate = "JK789LM"
console.log(cars);



/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/
cars.push({ brand: 'Lancia', model: 'Ypsilon', color: 'black', trims: ['non', 'so', 'che', 'sono'], licensePlate: 'NP159RS' });
console.log(cars);

/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
const justTrims = []
for (let i = 0; i < cars.length; i++) {
  justTrims.push(cars[i].trims[0]);
}
console.log(justTrims);

/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/
for (let i = 0; i < cars.length; i++) {
  if (cars[i].color[0] === 'b') {
    console.log("Fizz");
  } else {
    console.log("Buzz");
  }
}



/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
  6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
]
let index = 0;

while (index <= numericArray.length) {
  console.log(numericArray[index]);
  index++

  if (numericArray[index] === 32) {
    break;
  }
}

/* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/
const charactersArray = ['g', 'n', 'u', 'z', 'd']
const numbersArray = [];

for (let i = 0; i < charactersArray.length; i++) {
  numbersArray.push(charactersArray);
}

switch (numbersArray) {
  case 0:
    a = 1;
  case 1:
    b = 2;
  case 2:
    c = 3;
  case 3:
    d = 4;
  case 4:
    e = 5;
  case 5:
    f = 6;
  case 6:
    g = 7;
  case 7:
    h = 8;
  case 8:
    i = 9;
  case 9:
    l = 10;
  case 10:
    m = 11;
  case 11:
    n = 12;
  case 12:
    o = 13;
  case 13:
    p = 14;
  case 14:
    q = 15;
  case 15:
    r = 16;
  case 16:
    s = 17;
  case 17:
    t = 18;
  case 18:
    u = 19;
  case 19:
    v = 20;
  case 20:
    z = 21;
}



