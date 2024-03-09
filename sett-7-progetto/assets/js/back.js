let backTitle = document.getElementById('backTitle');
let inputName = document.getElementById('inputName');
let inputBrand = document.getElementById('inputBrand');
let inputPrice = document.getElementById('inputPrice');
let inputImgURL = document.getElementById('inputImgURL');
let inputDescription = document.getElementById('inputDescription');
let btnDelete = document.getElementById('btnDelete');
let btnReset = document.getElementById('btnReset');
let btnSave = document.getElementById('btnSave');
let error = document.getElementById('error');

let id;
let productId;

const key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZjBhMTJkN2IxMTAwMTkwZTcwZDkiLCJpYXQiOjE3MTAwMDg1MDgsImV4cCI6MTcxMTIxODEwOH0.1tVkkilUAEJyc017bFE9S882XV8PhLqbgSkMXe4ClYE"

const myURL = "https://striveschool-api.herokuapp.com/api/product/";



//load -> controlla se c'è id -> carica pagina per modificare o per aggiungere
window.addEventListener('load', function () {
    const params = new URLSearchParams(location.search);
    id = params.get('id');

    if (id) {
        backTitle.innerText = 'Modifica prodotto';
        findId(id);
    } else {
        backTitle.innerText = 'Aggiungi prodotto'
    }
})

//se pagina modifica, trova id del prodotto da modificare e pre-compila il form
async function findId(id) {
    try {
        let response = await fetch(myURL + id, {
            headers: {
                "Content-Type" : "application/json",
                "Authorization": key,
            }
        });
        let productId = await response.json();
        formWrite(productId);
    } catch (error) {
        console.log(error);
    }
}

function formWrite(productId) {
    inputName.value = productId.name;
    inputBrand.value = productId.brand;
    inputPrice.value = productId.price;
    inputImgURL.value = productId.imgURL;
    inputDescription.value = productId.description;    
}


//al click di salva fa la post o put (non funziona???)
btnSave.addEventListener('click', function(e) {
    e.preventDefault();

    const name = inputName.value;
    const brand = inputBrand.value;
    const price = inputPrice.value;
    const imgURL = inputImgURL.value;
    const description = inputDescription.value;

    const productId = {name, brand, price, imgURL, description};

    if (id) {
        modifyProduct(productId);
    } else {
        addProduct(productId);
    }
});

//POST
const addProduct = async (productId) => {
    try {
        let response = await fetch(myURL, {
            method: 'POST',
            body: JSON.stringify(productId),
            headers: {
                "Content-Type": "application/json",
                "Authorization": key
            }
        });
        let data = await response.json();
        location.href = 'index.html';
    } catch (error) {
        console.log(error);
    }
};

//PUT 
async function modifyProduct(productId) {
    try {
        let response = await fetch(myURL + id, {
            method: 'PUT',
            body: JSON.stringify(productId),
            headers: {
                "Content-Type": "application/json",
                "Authorization": key
            }
        });        
        let data = await response.json();
        location.href = 'index.html';
    } catch (error) {
        console.log(error);
    }
};

//DELETE
btnDelete.addEventListener('click', function(e) {
    e.preventDefault();
    productDelete();
})

async function productDelete() {
    try {
        let response = await fetch(myURL + id, {
            method: 'DELETE',
            headers: {
                "Authorization" : key,
                "Content-type" : "application/json",
            }
        });       
        
    } catch (error) {
        console.log(error);
    } location.href="index.html";
}
