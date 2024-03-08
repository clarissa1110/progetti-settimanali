let backTitle = document.getElementById('backTitle');
let inputName = document.getElementById('inputName');
let inputBrand = document.getElementById('inputBrand');
let inputPrice = document.getElementById('inputPrice');
let inputImgURL = document.getElementById('inputImgURL');
let inputDescription = document.getElementById('inputDescription');
let btnReset = document.getElementById('btnReset');
let btnSave = document.getElementById('btnSave');
let error = document.getElementById('error');

let productList = [];

let key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZjBhMTJkN2IxMTAwMTkwZTcwZDkiLCJpYXQiOjE3MDk4OTU4NDIsImV4cCI6MTcxMTEwNTQ0Mn0.WDyqLwGo3xmJX2tkJfnvYqQ1CLfwwTDC1UDAuRSHeVM"

let myURL = "https://striveschool-api.herokuapp.com/api/product/"

btnSave.addEventListener('click', function (e) {
    e.preventDefault();   

    const name = inputName.value;
    const brand = inputBrand.value;
    const price = inputPrice.value;
    const imgURL = inputImgURL.value;
    const description = inputDescription.value;
    const product = {name, brand, price, imgURL, description };

    console.log(product)
    addProduct(product);
})


const addProduct = async(product) => {
    try {
        let response = await fetch(myURL, {
            method: 'POST',
            body: JSON.stringify(product),
            headers: {
                "Content-Type": "application/json",
                "Authorization": key
            }
        })
        location.href = 'index.html';
        return response.json();
    } catch (error) {
        console.log(error);
    }
}







































/*const checkValidity = () => {
    let validity = true;
    productList.forEach((product) => {
        if (product.productName == inputName.value && product.brand == inputBrand.value && product.price == inputPrice.value && product.imgURL == inputImgURL.value && product.description == inputDescription.value) {
            error.innerText = 'Prodotto già inserito';
            validity = false;
        } else if (product.productName == '' && product.brand == '' && product.price == '' && product.imgURL == '' && product.description == '') {
            error.innerText = 'Compila tutti i campi!'
            validity = false;
        }
    })
    return console.log(validity);

} */