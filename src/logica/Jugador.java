/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

public class Jugador {

    private int id;
    private String nombre;
    private int nJugadas;
    private int tiempo;

    public Jugador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Jugador(int id, String nombre, int nJugadas, int tiempo) {
        this.id = id;
        this.nombre = nombre;
        this.nJugadas = nJugadas;
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnJugadas() {
        return nJugadas;
    }

    public void setnJugadas(int nJugadas) {
        this.nJugadas = nJugadas;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
