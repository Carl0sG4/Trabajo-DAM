var Baraja, Croupier, Jugador;
var juegoActivo = false; 

function iniciarJuego() {
    juegoActivo = true;
    Baraja = {
        cartas: [],
        inicializar: function() {
            this.cartas = [];
            var palos = ["corazones", "diamantes", "picas", "treboles"];
            for (var p = 0; p < palos.length; p++) {
                for (var v = 1; v <= 12; v++) {
                    var valorReal = v > 10 ? 10 : v;
                    this.cartas.push({ palo: palos[p], valor: valorReal });
                }
            }
        },
        barajar: function() {
            for (var i = this.cartas.length - 1; i > 0; i--) {
                var j = Math.floor(Math.random() * (i + 1));
                [this.cartas[i], this.cartas[j]] = [this.cartas[j], this.cartas[i]];
            }
        }
    };

    Croupier = {
        baraja: [],
        mano: [],
        puntuar: function(mano) {
            var total = 0;
            var ases = 0;
            for (var i = 0; i < mano.length; i++) {
                total += mano[i].valor;
                if (mano[i].valor === 1) ases++;
            }
            while (ases > 0 && total <= 11) {
                total += 10;
                ases--;
            }
            return total;
        },

        //Aqui he uitlizado algo que no vimos en clase y busque por internet(.this), pero basicamente hace referencia al objeto que contiene la función
        //ya que si no tendría no sabria cual de las variables utilizar y tendria que escribir mas repetitivo las variables
        repartirCarta: function() {
            return this.baraja.shift();
        },
        jugar: function() {
            while (this.puntuar(this.mano) < 17) {
                this.mano.push(this.repartirCarta());
            }
            mostrarResultado();
            juegoActivo = false; 
        }
    };

    Jugador = {
        mano: [],
        pedirCarta: function() {
            if (!juegoActivo) return; 
            this.mano.push(Croupier.repartirCarta());
            actualizarInterfaz();
            if (Croupier.puntuar(this.mano) > 21) {
                plantarme();
            }
        }
    };

    
    Baraja.inicializar();
    Baraja.barajar();
    Croupier.baraja = Baraja.cartas.slice();
    Jugador.mano = [Croupier.repartirCarta(), Croupier.repartirCarta()];
    Croupier.mano = [Croupier.repartirCarta(), Croupier.repartirCarta()];
    actualizarInterfaz();
}

//como no sabia integrar la puntución al html para que se viera, busque por internet y me ayude con chat gpt
function actualizarInterfaz() {
    var article = document.getElementById('table');
    article.innerHTML = `
        <h3>Tu mano (${Croupier.puntuar(Jugador.mano)} puntos):</h3>
        ${Jugador.mano.map(carta => `<div class="carta">${carta.valor} de ${carta.palo}</div>`).join('')}
        <h3>Crupier:</h3>
        <div class="carta">${Croupier.mano[0].valor} de ${Croupier.mano[0].palo}</div>
        <div class="carta">???</div>
    `;
}

function mostrarResultado() {
    var article = document.getElementById('table');
    var puntuacionJugador = Croupier.puntuar(Jugador.mano);
    var puntuacionCroupier = Croupier.puntuar(Croupier.mano);
    
    article.innerHTML += `
        <h3>Resultado final:</h3>
        <p>Jugador: ${puntuacionJugador} puntos</p>
        <p>Crupier: ${puntuacionCroupier} puntos</p>
        <p>${
            puntuacionJugador > 21 ? "¡Te pasaste! Perdiste." :
            puntuacionCroupier > 21 ? "Crupier se pasó. ¡Ganaste!" :
            puntuacionJugador > puntuacionCroupier ? "¡Ganaste!" :
            puntuacionJugador === puntuacionCroupier ? "Empate." :
            "Crupier gana."
        }</p>
    `;
    juegoActivo = false; 

    document.querySelector('.Pedir').disabled = true;
    document.querySelector('.Plantar').disabled = true;
}


function pedirCarta() {
    if (juegoActivo) Jugador.pedirCarta();
}

function plantarme() {
    if (juegoActivo) Croupier.jugar();
}

function reset() {
    iniciarJuego();

    document.querySelector('.Pedir').disabled = false;
    document.querySelector('.Plantar').disabled = false;
}

window.onload = iniciarJuego;
//He implantado un sistema para bloquear los botones para que cuando acabe el juego
//no siguan funcionando los botones (ya que me habia pasado en pruebas anteriores)

//También e implementado otro sistema que descative o difumine los botones cuando acaba el juego en la función (mostrarResultado) y (reset)