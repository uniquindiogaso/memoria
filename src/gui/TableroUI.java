package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import logica.Tablero;

/**
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
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
    private int id;

    private PrincipalUI pri;
    private ResultadosUI res;
    private Tablero tablero;
    
    /**
     * MÉTODO CONSTRUCTOR
     * @param pri
     * @param id
     * @param dificultad 
     */
    public TableroUI(PrincipalUI pri, int id, String dificultad) {
        this.pri = pri;
        tablero = new Tablero();
        this.dificultad = dificultad;
        this.id = id;
        bandera = false;
        inicializarComponetes();
    }

    /**
     * 
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
     * Genera un nuevo juego
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
     *
     * @param ae
     */
    private void accionVerificarJugada(ActionEvent ae) {
        for (int i = 0; i < btnJugadas.length; i++) {
            for (int j = 0; j < btnJugadas[i].length; j++) {
                if (ae.getSource() == btnJugadas[i][j]) {

                    if (!(btnJugadas[i][j].getIcon().toString().equals(defaultIcon.toString()))) {
                        break;
                    }
//                        
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
                                pri.getPrinLog().actualizarPuntajes(id, Integer.valueOf(lTiempo.getText()), numJugadas);
                                //System.out.println("" + pri.getPrinLog().getJugadores().size());
                                lGanador.setVisible(true);

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
