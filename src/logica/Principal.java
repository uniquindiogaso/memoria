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

    public void actualizarPuntajes(int jugadas, int tiempo, int id) {
        int p = buscarJugador(id);
        int j = jugadores.get(p).getnJugadas();
        int t = jugadores.get(p).getTiempo();
        if (jugadas < j && tiempo < t) {
            jugadores.get(p).setTiempo(tiempo);
            jugadores.get(p).setnJugadas(jugadas);
        }
    }
    
    

}
