/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Principal {

    private ArrayList<Jugador> jugadores;

    public Principal() {
        jugadores = new ArrayList<>();
    }

    public Principal(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int buscarJugador(int id) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean agregarJugador(String nom, int id) {
        if (buscarJugador(id) == -1) {
            return jugadores.add(new Jugador(id, nom));
        }
        return false;
    }

    public void actualizarPuntajes(int id, int tiempo, int jugadas) {
        int pos = buscarJugador(id);
        int j = jugadores.get(pos).getnJugadas();
        int t = jugadores.get(pos).getTiempo();
        if (j == 0 || t == 0) {
            jugadores.get(pos).setTiempo(tiempo);
            jugadores.get(pos).setnJugadas(jugadas);
        } else if (jugadas < j && tiempo < t) {
            jugadores.get(pos).setTiempo(tiempo);
            jugadores.get(pos).setnJugadas(jugadas);
        }
    }

    public String[][] listarJugadores() {
        String[][] listado = new String[jugadores.size()][3];
        for (int i = 0; i < listado.length; i++) {
            listado[i][0] = jugadores.get(i).getNombre();
            listado[i][1] = String.valueOf(jugadores.get(i).getnJugadas());
            listado[i][2] = String.valueOf(jugadores.get(i).getTiempo());
        }
        return listado;
    }

}
