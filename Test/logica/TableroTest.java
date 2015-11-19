package logica;

import java.net.URL;
import java.util.Arrays;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author gusta
 */
public class TableroTest {

    private static Tablero tablero = null;

    public TableroTest() {
    }

    /**
     * Al iniciacio del pool de pruebas se generara una instancia de tablero
     * para que las pruebas que lo requieran puedan usarla sin necesidad de
     * volver a crear e instanciar a tablero
     */
    @BeforeClass
    public static void inicializarClase() {
        tablero = new Tablero();
    }

    /**
     * Verificar si las dos jugadas son parejas validas
     * @result evaluar dentro del arreglo aleatorio los valores de las dos jugadas
     * buscando que sean iguales (parejas) 
     */
    @Test
    public void testAnalizarJugada() {
        int[][] matrizAletaroria = {{1, 2, 3, 4}, {5, 6, 7, 0}, {1, 2, 3, 4}, {5, 6, 7, 0}};
        int[] primeraJugada = {0, 1};
        int[] segundaJugada = {2, 1};

        boolean esPareja = tablero.analizarJugada(matrizAletaroria, primeraJugada, segundaJugada);

        assertTrue("La jugada analizada no es una pareja", esPareja);
    }

    /**
     * Evaluar si el tablero siempre es aleatorio
     * @result verifica que los tableros generados vs el sin ordenar no sean los mismos
     */
    @Test
    public void testConstruirTablero() {

        int[][] matrizOrdenada = {{0, 0, 1, 1}, {2, 2, 3, 3}, {4, 4, 5, 5}, {6, 6, 7, 7}};
        int[][] matrizAleatoria = tablero.construirTablero(4, 4);

        //assertArrayEquals(matrizOrdenada, matrizAleatoria);
        assertFalse("Tablero no es aleatorio", Arrays.equals(matrizOrdenada, matrizAleatoria));
    }

    /**
     * Comprobar que la URL de ubicacion del icono del boton sea correcta
     * @result Comprobrar que la URL formada no sea nula
     */
    @Test
    public void testObtenerImagen() {
        URL urlImagen = tablero.obtenerImagen("facil", 7);
        Assert.assertNotNull("Ruta de ubicación de la imagen mal formada", urlImagen);

    }
}
