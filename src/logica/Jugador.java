package logica;

/**
 * Ésta es la clase Jugador, que se encarga de manipular los datos del jugador
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class Jugador {

    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private int nJugadas;
    private int tiempo;

    /**
     * Método contructor de la clase Jugador, en el paquete logica, que
 inicializa sólo el codigo y el nombre
     *
     * @param codigo el código del jugador
     * @param nombre el nombre del jugador usado en la aplicación
     */
    public Jugador(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //MÉTODOS GETTERS AND SETTERS
    /**
     * Método get del Código del jugador
     *
     * @return el codigo del jugador
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método set del Código del jugador
     * @param codigo el código del jugador
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método get del Nombre del jugador
     * @return el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set del Nombre del jugador
     * @param nombre el nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get del Número de Jugadas del jugador en la partida
     * @return el número de jugadas del jugador
     */
    public int getnJugadas() {
        return nJugadas;
    }

    /**
     * Método set del Número de Jugadas del jugador en la partida
     * @param nJugadas el número de jugadas del jugador
     */
    public void setnJugadas(int nJugadas) {
        this.nJugadas = nJugadas;
    }

    /**
     * Método get del Tiempo en el que el jugador se demoró en terminar la partida
     * @return el tiempo con el que el jugador terminó la partida
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Método set del Tiempo en el que el jugador se demoró en terminar la partida
     * @param tiempo el tiempo el jugador
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Sobreescritura del método toString que muestra solamente el código y el
     * nombre del jugador
     *
     * @return el código y el nombre concatenados
     */
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
