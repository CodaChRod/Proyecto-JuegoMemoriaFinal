/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Vista.Avanzado;
import Vista.Intermedio;
import Vista.Jugador;
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
        this.modeloJugador = new Jugador();
      //  this.modeloTablero = new Tablero();
        // Estos 2 provicionales para Giuseppe
        this.modeloNivel = modeloNivel;
        this.ModeloCarta = ModeloCarta;
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
public void mostrarPuntaje(){
   x
}
}
