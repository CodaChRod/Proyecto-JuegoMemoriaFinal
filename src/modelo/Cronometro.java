/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.Timer;

/**
 *
 * @author bycha
 */
public class Cronometro {
    private Timer tiempo;
    private int segundos;
    private boolean activo;

    public Cronometro( int segundos, boolean activo) {
        this.segundos = 0;
        this.activo = false;
    }
    public void IniciarCronometro(){
        activo = true;
        tiempo = new Timer(1000, e -> {
    segundos++;
    
});
tiempo.start();
    }
    public int MostrarCronometro(int segundos){
         int min = segundos / 60;
        int seg = segundos % 60;
       return segundos;
    }
    
}
