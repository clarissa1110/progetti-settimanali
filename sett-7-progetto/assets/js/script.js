let productList = [];
let noItems = document.getElementById('noItems');
let cards = document.getElementById('cards');
let myURL = "https://striveschool-api.herokuapp.com/api/product/"
const key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZjBhMTJkN2IxMTAwMTkwZTcwZDkiLCJpYXQiOjE3MTAwMDg1MDgsImV4cCI6MTcxMTIxODEwOH0.1tVkkilUAEJyc017bFE9S882XV8PhLqbgSkMXe4ClYE"

window.addEventListener('load', init);

function init () {
    getProducts();
}

async function getProducts() {
    try {
        let get = await fetch (myURL, {
            headers: {
                'Content-Type' : 'application/json',
                'Authorization' : key,
            }
        });
        let response = await get.json();
        productList = response;
        console.log(productList);

        if (productList.length > 0) {
            printProduct();
        } else {
            noItems.innerText = 'Nessun prodotto inserito';
            return;
        }
    } catch (error) {
        console.log(error);
    }
}

const printProduct = () => {
    noItems.innerText = '';
    productList.forEach(element => {
        let card = document.createElement('div');
        card.classList.add('card');
        card.innerHTML = `
        <img src="${element.imageURL}" class="card-img-top">
        <div class="card-body">
            <h5 class="card-title">${element.name}</h5>
            <p class="card-text">${element.description}</p>
            <a href="back.html?id=${element.id}" class="btn btn-warning">Modifica</a>
            <a href="details.html?id=${element.id}" class="btn btn-info">Scopri di più</a>  
        </div>`;
        cards.appendChild(card);
    });
};

