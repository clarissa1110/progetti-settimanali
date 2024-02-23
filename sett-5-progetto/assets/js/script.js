
window.addEventListener('scroll', function () {
    let hero = document.getElementById('hero');
    let heroHeight = hero.offsetHeight;
    let button = document.getElementById('start');

    function cambiaColore() {

        if (window.scrollY >= heroHeight) {
            header.classList.add("headerScroll");
        } else {
            header.classList.remove("headerScroll");
        }
    }

    /*function cambiaButton() {
        if (window.scrollY >= heroHeight) {
            button.classList.add("buttonScroll");
        } else {
            button.classList.remove("buttonScroll");
        }
    }*/

    function cambiaButton() {

        if (window.scrollY >= heroHeight) {
            button.style.backgroundColor = "#1a8917";
        } else {
            button.style.backgroundColor = "#191919";
        }
    }

    cambiaColore();
    cambiaButton();
});


