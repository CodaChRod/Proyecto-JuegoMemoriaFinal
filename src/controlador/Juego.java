/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Vista.Avanzado;
import Vista.Intermedio;
import modelo.Jugador;
import Vista.Principiante;
import javax.swing.Timer;
import modelo.Carta;
import modelo.Cronometro;
import modelo.Nivel;
import modelo.Tablero;

/**
 *
 * @author bycha y Troll
 */
public class Juego {

    private Carta primeraCarta = null;
    private Carta segundaCarta = null;
    private boolean bloqueado = false;
    private Cronometro modeloCronometro;
    private Principiante vistaPrincipiante;
    private Intermedio vistaIntermedio;
    private Avanzado vistaAvanzado;
    private Timer timerControlador;
    
    //Controladores agregados despues de crear la clase jugador
    private Jugador modeloJugador;
    private Tablero modeloTablero;
    //procivional para que lo agregue Giuseppe
    private Nivel modeloNivel;
    private Carta ModeloCarta;

    public Juego(Cronometro modeloCronometro, Principiante vistaPrincipiante, Intermedio vistaIntermedio, Avanzado vistaAvanzado, Jugador modeloJugador, Tablero modeloTablero, Nivel modeloNivel, Carta ModeloCarta) {
        this.modeloCronometro = new Cronometro();
        this.vistaPrincipiante = vistaPrincipiante;
        this.vistaIntermedio = vistaIntermedio;
        this.vistaAvanzado = vistaAvanzado;
        this.modeloJugador = new Jugador(0,0,0);
      //  this.modeloTablero = new Tablero();
        // Estos 2 provicionales para Giuseppe
        this.modeloNivel = modeloNivel;
        this.ModeloCarta = ModeloCarta;
        this.modeloTablero = new Tablero(Nivel.PRINCIPIANTE);
    }
   
       public Juego(Principiante vistaPrincipiante) {
        this.vistaPrincipiante = vistaPrincipiante;
        this.modeloCronometro = new Cronometro();
        this.modeloJugador = new Jugador(0,0,0);
        this.modeloTablero = new Tablero(Nivel.PRINCIPIANTE);
    }
    
    public void iniciarJuegoControlador() {
        this.modeloCronometro.reiniciarCronometro();
        this.timerControlador = new Timer(1000, e -> {
            modeloCronometro.incrementarSegundoCronometro();        
            String tiempoTexto = modeloCronometro.obtenerTiempoFormateadoCronometro();
            vistaPrincipiante.actualizarTextoTiempoVista(tiempoTexto);
        });
        
        this.timerControlador.start();
    }

    public void detenerJuegoControlador() {
        if (this.timerControlador != null) {
            this.timerControlador.stop();
        }
    }
public void actualizarInformacionControlador() {
        if (vistaPrincipiante != null && modeloJugador != null && modeloTablero != null) {
            int puntaje = modeloJugador.obtenerPuntajeJugador();
            int intentos = modeloJugador.obtenerIntentosJugador();
            int parejasEncontradas = modeloJugador.obtenerParejasEncontradasJugador();
            int totalParejas = modeloTablero.obtenerNivelActualTablero().obtenerParejasNivel();
             vistaPrincipiante.actualizarInformacionVista(puntaje, intentos, parejasEncontradas, totalParejas);
        }
}

  public void seleccionarCartaControlador(int fila, int col) {
        if (bloqueado || modeloTablero == null) return;
        
        Carta cartaTocada = modeloTablero.obtenerCartaTablero(fila, col);
        if (cartaTocada == null || cartaTocada.esVisibleCarta() || cartaTocada.esEncontradaCarta()) return;
        
        // Revelar carta tocada
        cartaTocada.revelarCarta();
        vistaPrincipiante.actualizarBotonVista(fila, col, String.valueOf(cartaTocada.obtenerIdCarta()), false);
        
        // Primera carta del intento
        if (primeraCarta == null) {
            primeraCarta = cartaTocada;
        } else {
            // Segunda carta del intento
            segundaCarta = cartaTocada;
            
            // mira si coiciden
            if (modeloTablero.compararCartasTablero(primeraCarta, segundaCarta)) {
                primeraCarta.marcarEncontradaCarta();
                segundaCarta.marcarEncontradaCarta();
                
                modeloJugador.sumarPuntaje(100, true);
                modeloJugador.incrementarParejas(0, true);
                
                primeraCarta = null;
                segundaCarta = null;
                actualizarInformacionControlador();
            } else {
                // si no coiciden, resta puntos y tira pasusa de 2 secundos
                bloqueado = true;
                modeloJugador.restarPuntaje(20, true);
                modeloJugador.incrementarIntento(0, false);
                actualizarInformacionControlador();
                
                Timer timerOcultar = new Timer(2000, e -> {
                    primeraCarta.ocultarCarta();
                    segundaCarta.ocultarCarta();
                    
                    // Volver a poner [ ? ] en la vista
                    for (int f = 0; f < 4; f++) {
                        for (int c = 0; c < 4; c++) {
                            Carta cAux = modeloTablero.obtenerCartaTablero(f, c);
                            if (cAux != null && !cAux.esEncontradaCarta() && !cAux.esVisibleCarta()) {
                                vistaPrincipiante.actualizarBotonVista(f, c, "[ ? ]", false);
                            }
                        }
                    }
                    
                    primeraCarta = null;
                    segundaCarta = null;
                    bloqueado = false;
                });
                
                timerOcultar.setRepeats(false);
                timerOcultar.start();
            }
        }

}
  
}
