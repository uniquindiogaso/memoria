/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author gusta
 */
public class Principal {

    private ArrayList<Jugador> jugadores;
    private Jugador jug;

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

    public String[][] listarResultados() {

        ArrayList<Jugador> jugCopia = jugadores;
        
        String[][] lisResultados = new String[jugCopia.size()][3];
        for (int i = 0; i < lisResultados.length; i++) {
            for (int j = i; j < lisResultados.length; j++) {
                if (jugCopia.get(i).getnJugadas() != jugCopia.get(j).getnJugadas()) {
                    if (jugCopia.get(i).getnJugadas() > jugCopia.get(j).getnJugadas()) {
                        Jugador aux = jugCopia.get(i);
                        jugCopia.set(i, jugCopia.get(j));
                        jugCopia.set(j, aux);
                        System.out.println("ORGANIZÓ POR JUGADAS");
                        System.out.println("jugador 1" + jugCopia);
                    }
                }else{
                    if (jugCopia.get(i).getTiempo()> jugCopia.get(j).getTiempo()) {
                        Jugador aux = jugCopia.get(i);
                        jugCopia.set(i, jugCopia.get(j));
                        jugCopia.set(j, aux);
                        System.out.println("ORGANIZÓ POR TIEMPO");
                        System.out.println("jugador 1" + jugCopia);
                    }
                }
            }

        }
        System.out.println("jugador 1" + jugCopia);
        for (int i = 0; i < lisResultados.length; i++) {
            lisResultados[i][0] = jugCopia.get(i).getNombre();
            lisResultados[i][1] = String.valueOf(jugCopia.get(i).getnJugadas());
            lisResultados[i][2] = String.valueOf(jugCopia.get(i).getTiempo());
        }
        return lisResultados;
    }
    /*ArrayList<Jugador> jugClone;
     jugClone  = new ArrayList<>();*/

    public String[][] listar() {

        ArrayList<Jugador> jugClone = (ArrayList<Jugador>) jugadores.clone();

        String[][] lis = new String[jugadores.size()][3];

        //Collections.shuffle(jugClone);
        /*Collections.sort(jugClone, new Comparator() {
         });*/
        return lis;
    }
}
