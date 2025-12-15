//CONJUNTO 2 – Con condicionales, operadores y bucles

//1. Clasificación por edad
let edad = Number(prompt("Introduce tu edad: "));

if (edad <=12) {
    console.log("Niño");
} else if (edad <=17) {
    console.log("Adolescente");
} else if (edad <= 64) {
    console.log("Adulto");
} else {
    console.log("Jubilado");
}


//3. Contador ascendente o descendente
let numero = Number(prompt("Introduce un número: "));

if (numero = 0) {
    console.log(Number(0));
} else if (numero>0) {
    for(let i = 1; i <= numero; i++) {
        console.log(i);
    }
} else {
    for(let i = 0; i >= numero; i--) {
        console.log(i);
    }
}