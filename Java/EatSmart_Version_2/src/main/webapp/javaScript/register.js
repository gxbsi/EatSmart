let username;
let email;
let password;
let strasse;
let hausnummer;
let postleitzahl;
let stadt;
let land;
let gewicht;
let groesse;
let koerperfett;
let zielgewicht;
let zielkoerperfettanteil;


const setUserData = (fett, ziel) => {
    username = document.getElementById("username").value;
    email = document.getElementById("email").value;
    password = document.getElementById("password").value;
    strasse = document.getElementById("strasse").value;
    hausnummer = document.getElementById("hausnummer").value;
    postleitzahl = document.getElementById("postleitzahl").value;
    stadt = document.getElementById("stadt").value;
    land = document.getElementById("land").value;
    gewicht = document.getElementById("gewicht").value;
    groesse = document.getElementById("groesse").value;
    koerperfett = fett;
    zielgewicht = document.getElementById("zielgewicht").value;
    zielkoerperfettanteil = fett;

    console.log(email + land + zielgewicht);
}

