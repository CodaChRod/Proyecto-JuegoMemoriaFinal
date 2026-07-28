package modelo;

/**
 * @author Giusep
 */

public class Tablero {


    
    /*
     * Matriz bidimensional de objetos Carta que representa el tablero.
     */
    
    private Carta[][] matrizCartasTablero;
    
    private int filasTablero;
    private int columnasTablero;
    private int parejasEncontradasTablero;
    private Nivel nivelActualTablero;


    
    /*
     * Constructor del Tablero
     * Recibe el nivel deseado e inicializa la matriz y las parejas
     * 
     * @param nivelTablero Dificultad seleccionada (PRINCIPIANTE, INTERMEDIO, AVANZADO)
     */
    
    public Tablero(Nivel nivelTablero) {
        inicializarTablero(nivelTablero);
    }



    /*
     * Inicializa el tablero según el nivel seleccionado y mezcla las cartas
     * 
     * @param nivelTablero Nivel de dificultad
     */
    
    public final void inicializarTablero(Nivel nivelTablero) {
        this.nivelActualTablero = nivelTablero;
        this.filasTablero = nivelTablero.obtenerFilasNivel();
        this.columnasTablero = nivelTablero.obtenerColumnasNivel();
        this.parejasEncontradasTablero = 0;
        this.matrizCartasTablero = new Carta[filasTablero][columnasTablero];

        // Mezclar y colocar las cartas en la matriz
        distribuirParejasTablero();
    }

    /*
     * Llena las parejas usando un arreglo unidimensional Carta[],
     * las meclas manualmente con Math.random() (Algoritmo Fisher-Yates)
     * y las pasa a la matriz bidimensional Carta[][]
     */
    
    public void distribuirParejasTablero() {
        int totalParejas = nivelActualTablero.obtenerParejasNivel();
        int totalCartas = nivelActualTablero.obtenerTotalCartasNivel();
        
        // 1. Crear un arreglo unidimensional temporal con todas las cartas
        Carta[] arregloTemporalCartas = new Carta[totalCartas];

        int posicionArreglo = 0;
        // Llenar 2 cartas por cada ID de pareja (1,1, 2,2, 3,3... etc.)
        for (int idPareja = 1; idPareja <= totalParejas; idPareja++) {
            arregloTemporalCartas[posicionArreglo] = new Carta(idPareja);
            posicionArreglo++;
            
            arregloTemporalCartas[posicionArreglo] = new Carta(idPareja);
            posicionArreglo++;
        }

        // 2. Mezclar aleatoriamente el arreglo unidimensional (Intercambio manual)
        for (int i = 0; i < totalCartas; i++) {
            // Generar un índice aleatorio entre 0 y totalCartas - 1
            int indiceAleatorio = (int) (Math.random() * totalCartas);
            
            // Intercambiar elemento i con el elemento aleatorio (Swap)
            Carta cartaTemporal = arregloTemporalCartas[i];
            arregloTemporalCartas[i] = arregloTemporalCartas[indiceAleatorio];
            arregloTemporalCartas[indiceAleatorio] = cartaTemporal;
        }

        // 3. Pasar las cartas del arreglo 1D a la matriz bidimensional 2D (Carta[][])
        int indiceVector = 0;
        for (int f = 0; f < filasTablero; f++) {
            for (int c = 0; c < columnasTablero; c++) {
                matrizCartasTablero[f][c] = arregloTemporalCartas[indiceVector];
                indiceVector++;
            }
        }
    }

    /*
     * Obtiene la carta ubicada en una posición específica de la matriz
     * 
     * @param fila Coordenada de la fila (0 a filasTablero-1)
     * @param columna Coordenada de la columna (0 a columnasTablero-1)
     * @return Objeto Carta en esa posición, o null si la posición es inválida
     */
    
    public Carta obtenerCartaTablero(int fila, int columna) {
        if (fila >= 0 && fila < filasTablero && columna >= 0 && columna < columnasTablero) {
            return matrizCartasTablero[fila][columna];
        }
        return null;
    }

    /*
     * Compara si dos cartas seleccionadas son exactamente la misma pareja
     * @param primeraCarta Primera carta seleccionada
     * @param segundaCarta Segunda carta seleccionada
     * @return true si coinciden en ID, false en caso contrario
     */
    
    public boolean compararCartasTablero(Carta primeraCarta, Carta segundaCarta) {
        if (primeraCarta == null || segundaCarta == null) {
            return false;
        }
        return primeraCarta.esIgualCarta(segundaCarta);
    }

    /*
     * Incrementa en 1 el contador de parejas encontradas
     */
    
    public void incrementarParejasTablero() {
        this.parejasEncontradasTablero++;
    }

    /*
     * Verifica si el juego ha finalizado (si se encontraron todas las parejas del nivel)
     * @return true si se encontraron todas las parejas, false si faltan
     */
    
    public boolean esFinalizadoTablero() {
        return parejasEncontradasTablero == nivelActualTablero.obtenerParejasNivel();
    }

    /*
     * Reinicia el tablero volviendo a mezclar las cartas para una nueva partida
     */
    
    public void reiniciarTablero() {
        inicializarTablero(this.nivelActualTablero);
    }

 
    public Carta[][] obtenerMatrizTablero() {
        return matrizCartasTablero;
    }

    public int obtenerFilasTablero() {
        return filasTablero;
    }

    public int obtenerColumnasTablero() {
        return columnasTablero;
    }

    public int obtenerParejasEncontradasTablero() {
        return parejasEncontradasTablero;
    }

    public Nivel obtenerNivelActualTablero() {
        return nivelActualTablero;
    }
}