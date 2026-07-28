/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Vista.Menu;
import Vista.Principiante;
import modelo.Cronometro;

/**
 *
 * @author bycha
 */
public class Juego {
    private Cronometro modelo;
    private Menu menu;

    public Juego(Cronometro modelo, Menu menu) {
        this.modelo = modelo;
        this.menu = menu;
    }
    
    public void MostrarCronometro(){
        Timer tiempo = Cronometro.TxtTiempo;
    }
    
    
    
    
}
