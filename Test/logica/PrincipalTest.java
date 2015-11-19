/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LAURA
 */
public class PrincipalTest {

    private static Principal p;

    /**
     * Al iniciacio del pool de pruebas
     * se generara una instancia de principal
     * para que las pruebas que lo requieran puedan usarla 
     * sin necesidad de volver a crear e instanciar a principal
     */
    @BeforeClass
    public static void inicializarClase() {
        p = new Principal();
        llenarJugadores();
    }

    /**
     * Llenar datos de prueba de jugadores
     */
    public static void llenarJugadores() {
        p.agregarJugador("Laura", 1);
        p.agregarJugador("Cristian", 2);
        p.agregarJugador("Gaso", 3);
    }

    /**
     * Actualizar valores de pruebas
     * en los puntajes de los usuario
     */
    public static void actualizarPuntajesPruebas() {
        //Tiempo -- Jugadas
        p.actualizarPuntajes(1, 60, 20);
        p.actualizarPuntajes(2, 60, 22);
        p.actualizarPuntajes(3, 80, 50);
    }

    /**
     * Creacion de Usuario Exitosa
     * @result Se evalua que el usuario se agrego correctamente
     */
    @Test
    public void testAgregarJugador() {
        boolean e = p.agregarJugador("a", 4);
        Assert.assertTrue("El jugador ya esta registrado", e);
    }

    /**
     * Verificar que la busqueda de un jugador
     * @result Se evalua que el jugador buscado sea encontrado comparandolo contra un -1
     */
    @Test
    public void testBuscarJugador() {
        int cod = p.buscarJugador(3);
        Assert.assertTrue("El Jugador no se encuentra en la lista", cod != -1);
    }

    /**
     * Comprobar que se actualice las puntaciones del usuario 
     * @result Se verifica que el cambio de puntaje se realice exitoso
     */
    @Test
    public void testActualizarPuntajes() {
        boolean actualizado = p.actualizarPuntajes(3, 10, 20);
        
        //Prueba que el metodo retorne true cuando es una actualizacion exitosa
        Assert.assertTrue("No se logro actualizar el puntaje", actualizado);
        //Prueba que el valor almacenado sea el esperado
        Assert.assertTrue("El tiempo esperando no corresponde al almacenado", 10 == p.getJugadores().get(2).getTiempo());
    }

    /**
     * Verificar Matriz Ordenada
     * @result Evaluacion de matriz ordenada de resultados de acuerdo al puntaje y el tiempo
     */
    @Test
    public void testListarResultados() {
        Principal principal = new Principal();

        principal.agregarJugador("Laura", 1);
        principal.agregarJugador("Cristian", 2);
        principal.agregarJugador("Gaso", 3);

        principal.actualizarPuntajes(1, 60, 20);
        principal.actualizarPuntajes(2, 58, 20);
        principal.actualizarPuntajes(3, 80, 50);

        String[][] listaEsperada = {{"Cristian", "20", "58"}, {"Laura", "20", "60"}, {"Gaso", "50", "80"}};
        //String[][] listaEsperada = {{"Laura", "20", "60"}, {"Cristian", "22", "60"}, {"Gaso", "50", "80"}};
        String[][] listaOrdenada = principal.listarResultados();

        Assert.assertArrayEquals("Ordenamiento erroneo", listaEsperada, listaOrdenada);
    }

}
