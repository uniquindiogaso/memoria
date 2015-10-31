package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author gusta
 */
public class Tablero {

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
    
    public boolean analizarJugada(int[][] matrizAleatoria , int[] primeraJugada , int[] segundaJugada){
        return matrizAleatoria[primeraJugada[0]][primeraJugada[1]] == matrizAleatoria[segundaJugada[0]][segundaJugada[1]];
    }

}
