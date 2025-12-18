//CONJUNTO 3 – Tras introducir funciones

//4. Convertir una temperatura

/*Creamos dos funciones, para calcular la temperatura dependiendo del tipo de temperatura */
function fahrenheitACelsius(f) { //función para calcular temperatura en Celsius
    let tempcelsius = (f - 32) * 5/9;
    console.log("Tu temperatura de fahrenheit a Celsius: " + tempcelsius );
}

function celsiusAFahrenheit(c) { //función para calcular temperatura en Fahrenheit
    let tempfahren = (c * 9/5) + 32;
    console.log("Tu temperatura de celsius a Fahrenheit: " + tempfahren );
}

let temperatura = Number(prompt("Introduce una temperatura: ")); //introduce el usuario una temperatura

let opción = Number(prompt("Selecciones una opción (1. Para para temperatura Celsius - 2. Para temperatura en Fahrenheit) ")); //dependiendo de la opción que escoja (valor de la temperatura), se calcula el otro valor (valor que no selecciono)
if(opción == 1){
    celsiusAFahrenheit(temperatura);
} else if (opción == 2) {
    fahrenheitACelsius(temperatura);
}


//7. Función anónima para elevar al cubo

/* Utilizamos una función anónima con funcion de flecha para mostrar un número elevado al cubo */
let numero = Number(prompt("Inserta un número: "));
let operacion = (n) => n * n * n;

console.log("Número elevado al cubo: " + operacion(numero));