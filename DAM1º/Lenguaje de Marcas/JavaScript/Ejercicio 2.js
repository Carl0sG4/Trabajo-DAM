//CONJUNTO 2 – Con condicionales, operadores y bucles

//1. Clasificación por edad

/* Realizamos una clasificación de etapas segun la edad que pone el usuario y lo clasifica mediante if */
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

/* Introducimos un número (negativo o positivo), hace un bucle desde 0 o 1 dependiendo del signo hasta el número introducido */
let numero = Number(prompt("Introduce un número: "));

if (numero = 0) {
    console.log(Number(0));
} else if (numero>0) {
    for(let i = 1; i <= numero; i++) { //Seguimos el bucle para valores de i que sean menor que numero (ya que es positivo)
        console.log(i);
    }
} else {
    for(let i = 0; i >= numero; i--) { //Seguimos el bucle para valores de i que sean mayor que numero (ya que es negativo)
        console.log(i);
    }
}