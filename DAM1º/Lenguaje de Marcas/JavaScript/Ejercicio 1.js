//CONJUNTO 1 – Hasta Entrada/Salida (E/S)

//1. Mostrar datos personales
let nombre = prompt("¿Cuál es tu nombre?");
let apellidos = prompt("¿Cuáles son tus apellidos?");
let ciudad = prompt("¿Cuál es tu ciudad?");

console.log("Te llamas " + nombre + " "  + apellidos + " y vives en " + ciudad);

//6. Reutilizar variables
let edad = 32;
edad = Number(edad);
edad = String(edad);
edad = Boolean(edad);

console.log(typeof edad); // Muestra el último tipo de valor asignado (en este caso boolean)