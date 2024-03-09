let rowDetails = document.getElementById('rowDetails');
let id;
let productId;

const key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZjBhMTJkN2IxMTAwMTkwZTcwZDkiLCJpYXQiOjE3MTAwMDg1MDgsImV4cCI6MTcxMTIxODEwOH0.1tVkkilUAEJyc017bFE9S882XV8PhLqbgSkMXe4ClYE"

let myURL = "https://striveschool-api.herokuapp.com/api/product/";

window.addEventListener('load', function() {
    const params = new URLSearchParams(location.search);
    id = params.get('id');

    getProductId();
})

async function getProductId() {
    try {
        let get = await fetch (myURL + id, {
            headers: {
                "Content-Type" : "application/json",
                "Authorization" : key,
            }
        });
        let response = await get.json();
        productId = response;
        console.log(response)
        printProductDetails();
    } catch (error) {
        console.log(error);
    }
}

function printProductDetails() {
    rowDetails.innerHTML = `
    <div class="col-6"> 
        <img src="${productId.imgURL}"/>
    </div>
    <div class="col-6">
        <h5>${productId.brand}</h5>
        <h2>${productId.name}</h2>
        <h6>${productId.price}</h6>
        <p>${productId.description}</p>
    </div>`;
}