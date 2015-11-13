package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import logica.Principal;
import logica.Tablero;

public class TableroUI extends JFrame implements ActionListener {

    int FILAS = 4;
    int COLUMNAS = 4;

    private int numJugadas;
    private String dificultad;
    private JButton btnJugadas[][];
    private JLabel lLogo;
    private JLabel lJugadas;
    private JLabel lTiempo;
    private JLabel lGanador;
    private ImageIcon defaultIcon;
    private JButton btnResultados;
    private JButton btnRepetir;
    private JButton btnVolver;
    private Tablero tablero;
    int[][] matrizAleatoria;
    int[] posPrimeraJugada;
    int[] posSegundaJugada;
    private boolean tapar;
    private int parejasEncontradas;

    private PrincipalUI pri;
    private ResultadosUI res;
    private int id;

    //principal Id usuario
    //INSTANCIAS VENTANAS
    public TableroUI(PrincipalUI pri, int id, String dificultad) {
        this.pri = pri;
        tablero = new Tablero();
        this.dificultad = dificultad;
        this.id = id;
        tapar = false;
        inicializarComponetes();
    }

    public void inicializarComponetes() {
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
                //btnJugadas[i][j] = new JButton("NA");
                //btnJugadas[i][j].setBounds(110 + 95 * j, 150 + 95 * i, 90, 90);
                btnJugadas[i][j].setBounds(90 + 105 * j, 140 + 105 * i, 100, 100);
                btnJugadas[i][j].addActionListener(this);
                add(btnJugadas[i][j]);
            }
        }

        /*btnReiniciar = new JButton("Reiniciar Partida");
         btnReiniciar.setBounds(40, 600, 220, 48);
         add(btnReiniciar);
         btnReiniciar.setFont(new Font("Arial", Font.BOLD, 18));*/
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
            parejasEncontradas = 0;
            tablero.pararCronometro();
            lTiempo.setText("0");
            lGanador.setVisible(false);
            numJugadas = 0;
            lJugadas.setText(String.valueOf(numJugadas));
            matrizAleatoria = tablero.construirTablero(FILAS, COLUMNAS);

            for (int i = 0; i < btnJugadas.length; i++) {
                for (int j = 0; j < btnJugadas[i].length; j++) {
                    //btnJugadas[i][j].setText("NA");
                    btnJugadas[i][j].setIcon(defaultIcon);
                    btnJugadas[i][j].setEnabled(true);
                }
            }

        } else if (ae.getSource() == btnResultados) {
            res = new ResultadosUI(pri);
            res.setVisible(true);
            setVisible(false);
        } else {
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
                        //btnJugadas[i][j].setText(String.valueOf(matrizAleatoria[i][j]));
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
                                    System.out.println("" + pri.getPrinLog().getJugadores().size());
                                    lGanador.setVisible(true);

                                }

                            } else {
                                tapar = true;
                            }
                        } else {

                            if (tapar) {
                                btnJugadas[posPrimeraJugada[0]][posPrimeraJugada[1]].setIcon(defaultIcon);
                                btnJugadas[posSegundaJugada[0]][posSegundaJugada[1]].setIcon(defaultIcon);
                                tapar = false;
                            }
                            posPrimeraJugada = new int[]{i, j};
                        }

                    }
                }
            }

        }
    }

}
