/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author bycha
 */
public class Jugador {
    private int puntaje;
    private int intento;
    private int parencontrada;

    public Jugador(int puntaje, int intento, int parencontrada) {
        this.puntaje = 0;
        this.intento = 0;
        this.parencontrada = 0;
    }
    public void definirPuntajeMinimo(int puntaje){
        if(puntaje <0){
            this.puntaje = 0;
        }else{
            this.puntaje = puntaje;
        }
    }
    public void sumarPuntaje(int puntajre,boolean parencontrada){
        if(parencontrada){
            this.puntaje +=100;
        }else{
            this.puntaje = puntaje;
        }
    }
     public void restarPuntaje(int puntajre,boolean parencontrada){
        if(parencontrada){
            this.puntaje -=20;
        }else{
            this.puntaje = puntaje;
        }
    }
}

