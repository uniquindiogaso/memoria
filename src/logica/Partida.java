
package logica;

/**
 *
 * @author gusta
 */
public class Partida {

    private double tiempo;
    private int jugadas;
    

    public Partida() {
    }

    public Partida(double tiempo, int jugadas) {
        this.tiempo = tiempo;
        this.jugadas = jugadas;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

}
