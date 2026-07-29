/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Vista.Principiante;
import javax.swing.Timer;
import modelo.Cronometro;

/**
 *
 * @author bycha y Troll
 */
public class Juego {


    private Cronometro modeloCronometro;
    private Principiante vistaPrincipiante;
    private Timer timerControlador;
    public Juego(Principiante vistaPrincipiante) {
        this.vistaPrincipiante = vistaPrincipiante;
        this.modeloCronometro = new Cronometro();
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

}
