/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



/**
 *
 * @author bycha y Guisepe
 */
public class Cronometro {

    private int segundosCronometro;
    public Cronometro() {
        this.segundosCronometro = 0;
    }
    
   
    public void incrementarSegundoCronometro() {
        this.segundosCronometro++;
    }
    
    public void reiniciarCronometro() {
        this.segundosCronometro = 0;
    }
    /*
     * Formatea los segundos a formato mm:ss (ejemplo: "00:05").
     */
    public String obtenerTiempoFormateadoCronometro() {
        int min = segundosCronometro / 60;
        int seg = segundosCronometro % 60;
        return String.format("%02d:%02d", min, seg);
    }
    public int obtenerSegundosCronometro() {
        return segundosCronometro;
    }
}
