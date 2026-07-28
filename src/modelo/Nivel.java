package modelo;

/*
 * @author Giutroll
 */

public enum Nivel {
    
    // PRINCIPIANTE: 8 parejas = 16 cartas (Matriz 4 x 4)
    PRINCIPIANTE(8, 16, 4, 4),
    
    // INTERMEDIO: 16 parejas = 32 cartas (Matriz 4 x 8)
    INTERMEDIO(16, 32, 4, 8),
    
    // AVANZADO: 32 parejas = 64 cartas (Matriz 8 x 8)
    AVANZADO(32, 64, 8, 8);

    // Atributos de cada nivel
    private final int parejasNivel;
    private final int totalCartasNivel;
    private final int filasNivel;
    private final int columnasNivel;

    /*
     * Constructor del Enum Nivel.
     */
    private Nivel(int parejasNivel, int totalCartasNivel, int filasNivel, int columnasNivel) {
        this.parejasNivel = parejasNivel;
        this.totalCartasNivel = totalCartasNivel;
        this.filasNivel = filasNivel;
        this.columnasNivel = columnasNivel;
    }

    public int obtenerParejasNivel() {
        return parejasNivel;
    }

    public int obtenerTotalCartasNivel() {
        return totalCartasNivel;
    }

    public int obtenerFilasNivel() {
        return filasNivel;
    }

    public int obtenerColumnasNivel() {
        return columnasNivel;
    }
}