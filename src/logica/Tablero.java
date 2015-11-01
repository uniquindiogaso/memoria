package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author gusta
 */
public class Tablero {

    Timer timer = new Timer();

    /**
     *
     * @param filas
     * @param columnas
     * @return
     */
    public int[][] construirTablero(int filas, int columnas) {

        ArrayList<Integer> posiciones = new ArrayList<>();

        int[][] matrizAleatoria = new int[filas][columnas];

        for (int i = 0; i < (filas * columnas) / 2; i++) {
            posiciones.add(i);
            posiciones.add(i);
        }

        Collections.shuffle(posiciones);

        int con = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizAleatoria[i][j] = posiciones.get(con);
                con++;
            }

        }

        return matrizAleatoria;

    }

    public boolean analizarJugada(int[][] matrizAleatoria, int[] primeraJugada, int[] segundaJugada) {
        if (primeraJugada != null && segundaJugada != null) {
            return matrizAleatoria[primeraJugada[0]][primeraJugada[1]] == matrizAleatoria[segundaJugada[0]][segundaJugada[1]];

        }
        return false;

    }

    private void initCronometro() {
        timer.cancel();
        timer.purge();
        timer = new Timer();
    }

    public void iniciarCronometro(JLabel label) {
        initCronometro();

        TimerTask timerTask = new TimerTask() {
            int segundos = 0;
            public void run() {

                label.setText(String.valueOf(++segundos));
            }
        };
        // Dentro de 0 milisegundos avísame cada 1000 milisegundos
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void pararCronometro() {
        timer.cancel();
    }

}
