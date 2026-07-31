/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gius
 */
public class Carta {
    
  
   
     //* Identificador numérico de la pareja (ej: 1, 2, 3...)
   
    private int idCarta;
    
    /**
     * Indica si la carta está boca arriba (true) o boca abajo (false)
     */
    
    private boolean visibleCarta;
    
    /**
     * Indica si la pareja de esta carta ya fue adivinada
     */
    
    private boolean encontradaCarta;
    
    /**
     * Ruta o nombre de la imagen de la bandera asociada a la carta
     */
    
    private String rutaImagenCarta;
   
    
    /**
     * Constructor vacío por defecto
     * Inicializa la carta oculta y no encontrada
     */
    
    public Carta() {
        this.idCarta = 0;
        this.visibleCarta = false;
        this.encontradaCarta = false;
        this.rutaImagenCarta = "";
    }
    
   //constructor con id numeral, de prueba como lo comento el compañero daniel
    public Carta(int idCarta) {
        this.idCarta = idCarta;
        this.visibleCarta = false;
        this.encontradaCarta = false;
        this.rutaImagenCarta = "";
    }
    
    /*
     * Un costructor ya completo
     * Permite inicializar la carta con su ID y la ruta de la bandera
     * 
     * @param idCarta Identificador de la pareja
     * @param rutaImagenCarta Ruta de la imagen de la bandera
     */
    public Carta(int idCarta, String rutaImagenCarta) {
        this.idCarta = idCarta;
        this.visibleCarta = false;
        this.encontradaCarta = false;
        this.rutaImagenCarta = rutaImagenCarta;
    }
   
     //Muestra/voltea la carta boca arriba
    
    public void revelarCarta() {
        this.visibleCarta = true;
    }
   
     // Solo la oculta si no ha sido encontrada previamente
    
    public void ocultarCarta() {
        if (!this.encontradaCarta) {
            this.visibleCarta = false;
        }
    }
    
    /*
     * Marca la carta como encontrada/adivinada
     * La carta queda permanentemente boca arriba y visible
     */
    public void marcarEncontradaCarta() {
        this.encontradaCarta = true;
        this.visibleCarta = true;
    }
    
    /*
     * Compara si esta carta pertenece a la misma pareja que otra carta
     * 
     * @param otraCarta Objeto Carta con el que se desea comparar
     * @return true si ambas cartas tienen el mismo ID, false en caso contrario
     */
    public boolean esIgualCarta(Carta otraCarta) {
        if (otraCarta == null) {
            return false;
        }
        return this.idCarta == otraCarta.obtenerIdCarta();
    }
    
    /**
     * Restablece la carta a su estado inicial para una nueva partida
     */
    public void reiniciarCarta() {
        this.visibleCarta = false;
        this.encontradaCarta = false;
    }
    
    /*
     * Obtiene el ID numérico de la pareja de la carta
     * 
     * @return Número de ID de la carta
     */
    public int obtenerIdCarta() {
        return idCarta;
    }
    
    /*
     * Establece el ID numérico de la carta
     * 
     * @param idCarta Nuevo número de ID
     */
    public void establecerIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }
    
    /*
     * Consulta si la carta está visible (boca arriba)
     * 
     * @return true si está visible, false si está oculta
     */
    public boolean esVisibleCarta() {
        return visibleCarta;
    }
   
    /*
     * Establece el estado de visibilidad de la carta
     * 
     * @param visibleCarta true para mostrar, false para ocultar
     */
    public void establecerVisibleCarta(boolean visibleCarta) {
        this.visibleCarta = visibleCarta;
    }
    
    /*
     * Consulta si la carta ya fue encontrada/adivinada
     * 
     * @return true si fue encontrada, false en caso contrario
     */
    public boolean esEncontradaCarta() {
        return encontradaCarta;
    }
    
    /*
     * Establece el estado de encontrada de la carta
     * 
     * @param encontradaCarta true si ya se encontró la pareja
     */
    public void establecerEncontradaCarta(boolean encontradaCarta) {
        this.encontradaCarta = encontradaCarta;
    }
    
    /*
     * Obtiene la ruta de la imagen de la bandera asociadas a esta carta (para ya cuando se le ponga imagen)
     * 
     * @return Cadena con la ruta de la imagen
     */
    public String obtenerRutaImagenCarta() {
        return rutaImagenCarta;
    }
    
    /*
     * Establece la ruta de la imagen de la bandera (mismo para lo de arriba, cuando ya se tenga imagen)
     * 
     * @param rutaImagenCarta Ruta del archivo de imagen
     */
    public void establecerRutaImagenCarta(String rutaImagenCarta) {
        this.rutaImagenCarta = rutaImagenCarta;
    }
   
    //Para hacer pruebas en la consola
    @Override
    public String toString() {
        return "Carta{" +
                "id=" + idCarta +
                ", visible=" + visibleCarta +
                ", encontrada=" + encontradaCarta +
                ", ruta='" + rutaImagenCarta + '\'' +
                '}';
    }
    //comentario random
}
