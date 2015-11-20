package logica;

import gui.PrincipalUI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 * Clase principal de manejo del tablero del Juego
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class Tablero {

    //Definicion manejador de tiempos
    Timer timer = new Timer();

    /**
     * A travez de un Lista de numeros se construye una
     * matriz aleatoria de parejas
     * @param filas cantidad de filas que tendra la matriz aleatoria
     * @param columnas cantidad de columnas que tendra la matriz aleatoria
     * @return matriz de tamaño filas x columnas de parejas de numeros aleatorios
     */
    public int[][] construirTablero(int filas, int columnas) {

        ArrayList<Integer> posiciones = new ArrayList<>();
        int[][] matrizAleatoria = new int[filas][columnas];

        //Agregar dos veces el numero para generar las parejas
        for (int i = 0; i < (filas * columnas) / 2; i++) {
            posiciones.add(i);
            posiciones.add(i);
        }

        // Se encarga de barajar el contenido del ArrayList
        // enviando los valores a posiciones aleatorias
        Collections.shuffle(posiciones);

        //Se asigna valores a la matriz aleatoria de acuerdo al orden de
        // el arraylist posiciones
        int con = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizAleatoria[i][j] = posiciones.get(con);
                con++;
            }

        }

        return matrizAleatoria;

    }

    /**
     * Verifica que el valor contenido en dos posiciones de una matriz
     * sea el mismo
     * @param matrizAleatoria Matriz que contiene numeros aleatorios
     * @param primeraJugada Arreglo que contiene la posicion i - j del contenido de la primera jugada
     * @param segundaJugada Arreglo que contiene la posicion i - j del contenido de la segunda jugada
     * @return Verdadero si el valor en ambas posiciones es el mismo , falso si no coinciden los valores.
     */
    public boolean analizarJugada(int[][] matrizAleatoria, int[] primeraJugada, int[] segundaJugada) {
        if (primeraJugada != null && segundaJugada != null) {
            return matrizAleatoria[primeraJugada[0]][primeraJugada[1]] == matrizAleatoria[segundaJugada[0]][segundaJugada[1]];

        }
        return false;

    }

    /**
     * Inicializar el Cronometro
     */
    private void initCronometro() {
        timer.cancel();
        timer.purge();
        timer = new Timer();
    }

    /**
     * Iniciar la Tarea de Actualizar el componente
     * @param label Componente que sera actualiado
     */
    public void iniciarCronometro(JLabel label) {
        initCronometro();

        //Definir tarea de tiempo
        TimerTask timerTask = new TimerTask() {
            int segundos = 0;
            //Cada que el schedule(programador) se deba ejecitar ( 1 segundo = 1000 milisegundos)
            //actualizara el valor del label pasado como parametro
            public void run() {
                label.setText(String.valueOf(++segundos));
            }
        };
        // Dentro de 0 milisegundos avísame cada 1000 milisegundos
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    /**
     * Detener la ejecucion del timer
     */
    public void pararCronometro() {
        timer.cancel();
    }

    /**
     * Obtener Ruta Imagen En base a la dificultad y la numero aleatorio se
     * genera una cadena que contiene la ruta completa de la imagen
     *
     * @param dificultad carpeta donde se exploraran las imagnes
     * @param pos nombre de la imagen que se va a abrir
     * @return Url formada con la ruta de la imagen o null si no se logro formar
     */
    public URL obtenerImagen(String dificultad, int pos) {
        return this.getClass().getResource(PrincipalUI.IMAGENES + dificultad.toLowerCase() + "/" + pos + ".png");
    }
}
