//CONJUNTO 3 – Tras introducir funciones

//4. Convertir una temperatura
function fahrenheitACelsius(f) {
    let tempcelsius = (f - 32) * 5/9;
    console.log("Tu temperatura de fahrenheit a Celsius: " + tempcelsius );
}

function celsiusAFahrenheit(c) {
    let tempfahren = (c * 9/5) + 32;
    console.log("Tu temperatura de celsius a Fahrenheit: " + tempfahren );
}

let temperatura = Number(prompt("Introduce una temperatura: "));

let opción = Number(prompt("Selecciones una opción (1. Para para temperatura Celsius - 2. Para temperatura en Fahrenheit) "));
if(opción == 1){
    celsiusAFahrenheit(temperatura);
} else if (opción == 2) {
    fahrenheitACelsius(temperatura);
}


//8. Encadenar funciones
