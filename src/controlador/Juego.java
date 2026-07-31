/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Vista.Avanzado;
import Vista.Intermedio;
import Vista.Principiante;
import javax.swing.Timer;
import modelo.Carta;
import modelo.Cronometro;
import modelo.Jugador;
import modelo.Nivel;
import modelo.Tablero;

/**
 * @author Daniel y Jvoid
 */
public class Juego {

    private Carta primeraCarta = null;
    private Carta segundaCarta = null;
    private boolean bloqueado = false;
    
    private Cronometro modeloCronometro;
    private Jugador modeloJugador;
    private Tablero modeloTablero;
    
    private Principiante vistaPrincipiante;
    private Intermedio vistaIntermedio;
    private Avanzado vistaAvanzado;
    
    private Timer timerControlador;


    public Juego(Principiante vistaPrincipiante) {
        this.vistaPrincipiante = vistaPrincipiante;
        this.modeloCronometro = new Cronometro();
        this.modeloJugador = new Jugador(0, 0, 0);
        this.modeloTablero = new Tablero(Nivel.PRINCIPIANTE);
    }

    public Juego(Intermedio vistaIntermedio) {
        this.vistaIntermedio = vistaIntermedio;
        this.modeloCronometro = new Cronometro();
        this.modeloJugador = new Jugador(0, 0, 0);
        this.modeloTablero = new Tablero(Nivel.INTERMEDIO);
    }

    public Juego(Avanzado vistaAvanzado) {
        this.vistaAvanzado = vistaAvanzado;
        this.modeloCronometro = new Cronometro();
        this.modeloJugador = new Jugador(0, 0, 0);
        this.modeloTablero = new Tablero(Nivel.AVANZADO);
    }


    public void actualizarTextoTiempoControlador(String tiempoTexto) {
        if (vistaPrincipiante != null) {
            vistaPrincipiante.actualizarTextoTiempoVista(tiempoTexto);
        } else if (vistaIntermedio != null) {
            vistaIntermedio.actualizarTextoTiempoVista(tiempoTexto);
        } else if (vistaAvanzado != null) {
            vistaAvanzado.actualizarTextoTiempoVista(tiempoTexto);
        }
    }

    public void actualizarInformacionControlador() {
        if (modeloJugador != null && modeloTablero != null) {
            int puntaje = modeloJugador.obtenerPuntajeJugador();
            int intentos = modeloJugador.obtenerIntentosJugador();
            int parejasEncontradas = modeloJugador.obtenerParejasEncontradasJugador();
            int totalParejas = modeloTablero.obtenerNivelActualTablero().obtenerParejasNivel();

            if (vistaPrincipiante != null) {
                vistaPrincipiante.actualizarInformacionVista(puntaje, intentos, parejasEncontradas, totalParejas);
            } else if (vistaIntermedio != null) {
                vistaIntermedio.actualizarInformacionVista(puntaje, intentos, parejasEncontradas, totalParejas);
            } else if (vistaAvanzado != null) {
                vistaAvanzado.actualizarInformacionVista(puntaje, intentos, parejasEncontradas, totalParejas);
            }
        }
    }

    public void actualizarBotonControlador(int fila, int col, String texto, boolean deshabilitado) {
        if (vistaPrincipiante != null) {
            vistaPrincipiante.actualizarBotonVista(fila, col, texto, deshabilitado);
        } else if (vistaIntermedio != null) {
            vistaIntermedio.actualizarBotonVista(fila, col, texto, deshabilitado);
        } else if (vistaAvanzado != null) {
            vistaAvanzado.actualizarBotonVista(fila, col, texto, deshabilitado);
        }
    }
    public void verificarVictoriaControlador() {
        detenerJuegoControlador(); // Apaga el reloj
        
        if (vistaPrincipiante != null) {
            vistaPrincipiante.mostrarVictoriaVista();
        } else if (vistaIntermedio != null) {
            vistaIntermedio.mostrarVictoriaVista();
        } else if (vistaAvanzado != null) {
            vistaAvanzado.mostrarVictoriaVista();
        }
    }


    public void iniciarJuegoControlador() {
        this.modeloCronometro.reiniciarCronometro();
        this.timerControlador = new Timer(1000, e -> {
            modeloCronometro.incrementarSegundoCronometro();
            String tiempoTexto = modeloCronometro.obtenerTiempoFormateadoCronometro();
            actualizarTextoTiempoControlador(tiempoTexto);
        });
        this.timerControlador.start();
        actualizarInformacionControlador();
    }

    public void detenerJuegoControlador() {
        if (this.timerControlador != null) {
            this.timerControlador.stop();
        }
    }


    public void seleccionarCartaControlador(int fila, int col) {
        if (bloqueado || modeloTablero == null) return;
        
        Carta cartaTocada = modeloTablero.obtenerCartaTablero(fila, col);
        if (cartaTocada == null || cartaTocada.esVisibleCarta() || cartaTocada.esEncontradaCarta()) return;
        
        // Revelar carta tocada
        cartaTocada.revelarCarta();
        actualizarBotonControlador(fila, col, String.valueOf(cartaTocada.obtenerIdCarta()), false);
        
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
                modeloTablero.incrementarParejasTablero();
                
                primeraCarta = null;
                segundaCarta = null;
                actualizarInformacionControlador();

                // verifica mediante las parejas conbetidas, si ya se gano
                if (modeloTablero.esFinalizadoTablero() || modeloJugador.obtenerParejasEncontradasJugador() >= modeloTablero.obtenerNivelActualTablero().obtenerParejasNivel()) {
                    detenerJuegoControlador();
                    verificarVictoriaControlador();
                }

            } else {
                // si no coiciden
                bloqueado = true;
                modeloJugador.restarPuntaje(20, true);
                modeloJugador.incrementarIntento(0, false);
                actualizarInformacionControlador();
                
                Timer timerOcultar = new Timer(2000, e -> {
                    primeraCarta.ocultarCarta();
                    segundaCarta.ocultarCarta();
                    
                    // Volver a poner [ ? ] en las posiciones del tablero   
                    int filas = modeloTablero.obtenerFilasTablero();
                    int cols = modeloTablero.obtenerColumnasTablero();

                    for (int f = 0; f < filas; f++) {
                        for (int c = 0; c < cols; c++) {
                            Carta cAux = modeloTablero.obtenerCartaTablero(f, c);
                            if (cAux != null && !cAux.esEncontradaCarta() && !cAux.esVisibleCarta()) {
                                actualizarBotonControlador(f, c, "[ ? ]", false);
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