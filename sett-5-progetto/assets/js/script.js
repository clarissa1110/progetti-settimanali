let header = document.getElementById('header');
let heroHeight = header.offsetTop;


function cambiaColore() {
    if (window.scrollY >= heroHeight) {
        header.style.backgroundColor('white')
    } else {
        header.style.backgroundColor('#ffc017')
    }
}

cambiaColore();