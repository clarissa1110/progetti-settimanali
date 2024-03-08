let productList = [];
let noItems = document.getElementById('noItems');
let cards = document.getElementById('cards');
let myURL = "https://striveschool-api.herokuapp.com/api/product/"
let key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZjBhMTJkN2IxMTAwMTkwZTcwZDkiLCJpYXQiOjE3MDk4OTU4NDIsImV4cCI6MTcxMTEwNTQ0Mn0.WDyqLwGo3xmJX2tkJfnvYqQ1CLfwwTDC1UDAuRSHeVM"

window.addEventListener('load', init);

function init () {
    getProducts();
}

async function getProducts() {
    try {
        let get = await fetch (myURL, {
            headers: {
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
        console.log(error)
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
            <h5 class="card-title">${element.productName}</h5>
            <p class="card-text">${element.description}</p>
            <a href="back.html?id=${element._id}" class="btn btn-warning">Modifica</a>
            <a href="detail.html?id=${element._id}" class="btn btn-info">Scopri di più</a>          
        `;
        
    })
}

