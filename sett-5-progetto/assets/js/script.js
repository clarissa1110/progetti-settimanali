

let header = document.getElementById('header');
let heroHeight = document.getElementById('hero');

function cambiaColore() {
    if (window.scrollY >= heroHeight.offsetHeight) {
        header.style.backgroundColor('white')
}
}