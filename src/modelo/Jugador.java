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
    private int parEncontrada;

    public Jugador(int puntaje, int intento, int parencontrada) {
        this.puntaje = 0;
        this.intento = 0;
        this.parEncontrada = 0;
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
     public void restarPuntaje(int puntaje,boolean parencontrada){
        if(parencontrada){
            this.puntaje -=20;
        }else{
            this.puntaje = puntaje;
        }
    }
     public String MostrarPuntaje (){
         return String.format("%d", puntaje);
     }
     public int incrementarIntento(int intento, boolean encontradaCarta){
         if (encontradaCarta == false){
             intento ++;
         }
         return intento;
     }
      public String MostrarIntento (){
         return String.format("%d", intento);
     }
      public int incrementarParejas(int parEncontrada, boolean encontradaCarta){
         if (encontradaCarta == true){
             parEncontrada ++;
         }
         return parEncontrada;
}
        public String MostrarParejas (){
         return String.format("%d", parEncontrada);
     }
}

