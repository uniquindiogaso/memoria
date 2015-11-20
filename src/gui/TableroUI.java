package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Tablero;

/**
 * Ésta Interfaz muestra la pantalla del juego
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class TableroUI extends JFrame implements ActionListener {

    private int FILAS = 4;
    private int COLUMNAS = 4;

    private JLabel lLogo;
    private JLabel lJugadas;
    private JLabel lTiempo;
    private JLabel lGanador;

    private JButton btnResultados;
    private JButton btnRepetir;
    private JButton btnVolver;

    private JButton btnJugadas[][];

    private ImageIcon defaultIcon;

    private String dificultad;

    private int[][] matrizAleatoria;
    private int[] posPrimeraJugada;
    private int[] posSegundaJugada;
    private boolean bandera;
    private int parejasEncontradas;
    private int numJugadas;
    private int codigo;

    private PrincipalUI pri;
    private ResultadosUI res;
    private Tablero tablero;

    /**
     * Método constructor de la clase TableroUI
     *
     * @param pri objeto tipo PrincipalUI, que es la ventana principal de la
     * aplicación
     * @param codigo el código del jugador que va a jugar la partida
     * @param dificultad el grado de doficultad con la cual el jugador jugará la
     * partida
     */
    public TableroUI(PrincipalUI pri, int codigo, String dificultad) {
        this.pri = pri;
        tablero = new Tablero();
        this.dificultad = dificultad;
        this.codigo = codigo;
        bandera = false;
        inicializarComponetes();
    }

    /**
     * Inicializa los componentes utilizados en la ventana TableroUI
     */
    private void inicializarComponetes() {
        setTitle("..: Paranoic Memory :..");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600, 725);
        setLocationRelativeTo(null);

        btnJugadas = new JButton[FILAS][COLUMNAS];

        defaultIcon = new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "default.png"));
        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 60);
        add(lLogo);

        lJugadas = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "numjugadas.png")));
        lJugadas.setBounds(95, 75, 140, 64);
        add(lJugadas);
        lJugadas.setText("0");
        lJugadas.setFont(new Font("Arial", Font.BOLD, 28));

        lTiempo = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "time.png")));
        lTiempo.setBounds(320, 80, 180, 48);
        add(lTiempo);
        lTiempo.setText("0");
        lTiempo.setFont(new Font("Arial", Font.BOLD, 28));

        lGanador = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "ganar.gif")));
        lGanador.setBounds(95, 280, 397, 223);
        add(lGanador);
        lGanador.setVisible(false);

        matrizAleatoria = tablero.construirTablero(FILAS, COLUMNAS);

        for (int i = 0; i < btnJugadas.length; i++) {
            for (int j = 0; j < btnJugadas[i].length; j++) {
                btnJugadas[i][j] = new JButton(defaultIcon);
                btnJugadas[i][j].setBounds(90 + 105 * j, 140 + 105 * i, 100, 100);
                btnJugadas[i][j].addActionListener(this);
                add(btnJugadas[i][j]);
            }
        }

        btnResultados = new JButton("Resultados");
        btnResultados.setBounds(60, 625, 220, 48);
        add(btnResultados);
        btnResultados.setFont(new Font("Arial", Font.BOLD, 18));
        btnResultados.addActionListener(this);

        btnRepetir = new JButton(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "play.png")));
        btnRepetir.setText("Volver a jugar");
        btnRepetir.setBounds(190, 565, 220, 48);
        add(btnRepetir);
        btnRepetir.setFont(new Font("Arial", Font.BOLD, 18));
        btnRepetir.addActionListener(this);

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "return.png")));
        btnVolver.setText("Volver");
        btnVolver.setBounds(310, 625, 220, 48);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);

    }

    /**
     * Gestor de eventos generados en la ventana
     *
     * @param ae - origen del evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnVolver) {
            pri.setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == btnRepetir) {
            accionRepetirJuego();
        } else if (ae.getSource() == btnResultados) {
            res = new ResultadosUI(pri);
            res.setVisible(true);
            setVisible(false);
        } else {
            accionVerificarJugada(ae);
        }
    }

    /**
     * Al dar clic sobre el botón repetir se genera una nueva partida con
     * jugadas y tiempo desde cero
     */
    private void accionRepetirJuego() {
        parejasEncontradas = 0;
        tablero.pararCronometro();
        lTiempo.setText("0");
        lGanador.setVisible(false);
        numJugadas = 0;
        lJugadas.setText(String.valueOf(numJugadas));
        matrizAleatoria = tablero.construirTablero(FILAS, COLUMNAS);

        for (JButton[] btnJugada : btnJugadas) {
            for (JButton btnJugada1 : btnJugada) {
                btnJugada1.setIcon(defaultIcon);
                btnJugada1.setEnabled(true);
            }
        }
    }

    /**
     * Verifica las jugadas del jugador a través de los clics que éste realice
     *
     * @param ae objeto tipo ActionEvent que gestiona los eventos de la ventana
     */
    private void accionVerificarJugada(ActionEvent ae) {
        for (int i = 0; i < btnJugadas.length; i++) {
            for (int j = 0; j < btnJugadas[i].length; j++) {
                if (ae.getSource() == btnJugadas[i][j]) {

                    if (!(btnJugadas[i][j].getIcon().toString().equals(defaultIcon.toString()))) {
                        break;
                    }

                    //Aumentar la Cantidad de Jugadas Realizadas
                    lJugadas.setText(String.valueOf(++numJugadas));

                    //Iniciar Conteo
                    if (numJugadas == 1) {
                        tablero.iniciarCronometro(lTiempo);
                    }

                    btnJugadas[i][j].setIcon(new ImageIcon(tablero.obtenerImagen(dificultad, matrizAleatoria[i][j])));

                    if (numJugadas % 2 == 0) {

                        posSegundaJugada = new int[]{i, j};

                        boolean pareja = tablero.analizarJugada(matrizAleatoria, posPrimeraJugada, posSegundaJugada);

                        if (pareja) {
                            btnJugadas[posPrimeraJugada[0]][posPrimeraJugada[1]].setEnabled(false);
                            btnJugadas[posPrimeraJugada[0]][posPrimeraJugada[1]].setOpaque(false);
                            btnJugadas[posSegundaJugada[0]][posSegundaJugada[1]].setEnabled(false);
                            btnJugadas[posSegundaJugada[0]][posSegundaJugada[1]].setOpaque(false);

                            ++parejasEncontradas;

                            if (parejasEncontradas == (FILAS * COLUMNAS) / 2) {
                                tablero.pararCronometro();
                                if (pri.getPrinLog().actualizarPuntajes(codigo, Integer.valueOf(lTiempo.getText()), numJugadas)) {
                                    lGanador.setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se logró actualizar su puntaje", "Upss!", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } else {
                            bandera = true;
                        }
                    } else {

                        if (bandera) {
                            btnJugadas[posPrimeraJugada[0]][posPrimeraJugada[1]].setIcon(defaultIcon);
                            btnJugadas[posSegundaJugada[0]][posSegundaJugada[1]].setIcon(defaultIcon);
                            bandera = false;
                        }
                        posPrimeraJugada = new int[]{i, j};
                    }

                }
            }
        }
    }

}
