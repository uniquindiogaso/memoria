package logica;

import java.util.ArrayList;

/**
 * Ésta es la clase Principal, que se encarga de manipular todas las acciones
 * que se le hagan a los jugadores, como buscarlos, agregarlos, actualizarlos y
 * listarlos
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class Principal {

    //ATRIBUTOS
    private ArrayList<Jugador> jugadores;

    /**
     * Método constructor de la clase Principal que inicializa el ArrayList de jugadores
     */
    public Principal() {
        jugadores = new ArrayList<>();
    }

    /**
     * Método constructor de la clase Principal 
     * @param jugadores el ArrayList de jugadores
     */
    public Principal(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    //MÉTODOS GETTERS AND SETTERS
    
    /**
     * Método get del ArrayList de jugadores
     * @return el ArrayList de jugadores
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Método set del ArrayList de jugadores
     * @param jugadores el ArrayList 
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    //MÉTODOS
    
    /**
     * Busca el jugador dentro del ArrayList
     * @param codigo el código del jugador a buscar
     * @return la posición en donde está el jugador o -1 si no lo encuentra
     */
    public int buscarJugador(int codigo) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Agrega el jugador al ArrayList de jugadores
     * @param nom el nombre del jugador a agregar
     * @param codigo el código del jugador a agregar
     * @return true si se agregó el jugador, de lo contrario false si no se pudo agregar
     */
    public boolean agregarJugador(String nom, int codigo) {
        if (buscarJugador(codigo) == -1) {
            return jugadores.add(new Jugador(codigo, nom));
        }
        return false;
    }

    /**
     * Actualiza el puntaje del jugador
     * @param codigo el código del jugador al que se le va a actualizar el puntaje
     * @param tiempo el nuevo tiempo del jugador
     * @param jugadas las nuevas cantidades de jugadas del jugador
     * @return true si se pudo actualizar el puntaje, de lo contrario false si no pudo actualizar
     */
    public boolean actualizarPuntajes(int codigo, int tiempo, int jugadas) {
        int pos = buscarJugador(codigo);
        if (pos != -1) {
            int j = jugadores.get(pos).getnJugadas();
            int t = jugadores.get(pos).getTiempo();
            if (j == 0 || t == 0) {
                jugadores.get(pos).setTiempo(tiempo);
                jugadores.get(pos).setnJugadas(jugadas);
            } else if (jugadas < j && tiempo < t) {
                jugadores.get(pos).setTiempo(tiempo);
                jugadores.get(pos).setnJugadas(jugadas);
            }
            return true;
        }
        return false;
    }

    /**
     * Genera la lista de los jugadores
     * @return una matriz  de String con la lista de los jugadores
     */
    public String[][] listarJugadores() {
        String[][] listado = new String[jugadores.size()][3];
        for (int i = 0; i < listado.length; i++) {
            listado[i][0] = jugadores.get(i).getNombre();
            listado[i][1] = String.valueOf(jugadores.get(i).getnJugadas());
            listado[i][2] = String.valueOf(jugadores.get(i).getTiempo());
        }
        return listado;
    }

    /**
     * Genera la lista de los resultados de los jugadores ordenados con el número de jugadas de menor a mayor
     * @return una matriz de String con la lista de jugadores ordenada según los resultados
     */
    public String[][] listarResultados() {

        ArrayList<Jugador> listaJugadores = jugadores;

        String[][] lisResultados = new String[listaJugadores.size()][3];
        
        for (int i = 0; i < lisResultados.length; i++) {
            for (int j = i; j < lisResultados.length; j++) {
                if (listaJugadores.get(i).getnJugadas() != listaJugadores.get(j).getnJugadas()) {
                    if (listaJugadores.get(i).getnJugadas() > listaJugadores.get(j).getnJugadas()) {
                        Jugador aux = listaJugadores.get(i);
                        listaJugadores.set(i, listaJugadores.get(j));
                        listaJugadores.set(j, aux);
                    }
                } else {
                    if (listaJugadores.get(i).getTiempo() > listaJugadores.get(j).getTiempo()) {
                        Jugador aux = listaJugadores.get(i);
                        listaJugadores.set(i, listaJugadores.get(j));
                        listaJugadores.set(j, aux);
                    }
                }
            }

        }
        for (int i = 0; i < lisResultados.length; i++) {
            lisResultados[i][0] = listaJugadores.get(i).getNombre();
            lisResultados[i][1] = String.valueOf(listaJugadores.get(i).getnJugadas());
            lisResultados[i][2] = String.valueOf(listaJugadores.get(i).getTiempo());
        }
        return lisResultados;
    }
}
