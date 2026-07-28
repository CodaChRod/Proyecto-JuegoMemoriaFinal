/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Vista.Menu;
import Vista.Principiante;
import javax.swing.Timer;
import modelo.Cronometro;

/**
 *
 * @author bycha
 */
public class Juego {

    private Cronometro modelo;
    private Menu menu;
    private Principiante principiante;

    public Juego(Cronometro modelo, Menu menu) {
        this.modelo = modelo;
        this.menu = menu;
    }

    public void IniciarCronometro(boolean activo) {
        menu.IniciarCronometro(true);
    }

    public void MostrarCronometro(int segundos) {
        //Timer tiempo = Cronometro.Principiante;
        principiante.setToolTipText(segundos);
        
       
       
       
    }

}
