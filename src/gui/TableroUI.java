package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import logica.Tablero;

public class TableroUI extends JFrame implements ActionListener {

    int FILAS = 4;
    int COLUMNAS = 4;

    private static final String IMAGENES = "../media/imagenes/";
    
    private int numJugadas;
    
    private JButton btnJugadas[][];
    private JLabel lLogo;
    private JLabel lJugadas;
    private JLabel lTiempo;
    private ImageIcon defaultIcon;

    private JButton btnReiniciar;
    private JButton btnResultados;
    private JButton btnRepetir;
    private JButton btnVolver;
    private Tablero tablero;
    int[][] matrizAleatoria;
    
    int[] posPrimeraJugada;
    int[] posSegundaJugada;

    public TableroUI() {        
        tablero = new Tablero();
        
        inicializarComponetes();
    }

    public void inicializarComponetes() {
        setLayout(null);
        btnJugadas = new JButton[FILAS][COLUMNAS];

        defaultIcon = new ImageIcon(this.getClass().getResource(IMAGENES + "default.png"));
        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 66);
        add(lLogo); 

        lJugadas = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "numjugadas.png")));
        lJugadas.setBounds(75, 90, 140, 64);
        add(lJugadas);
        lJugadas.setText("0");
        lJugadas.setFont(new Font("Arial", Font.BOLD, 28));

        lTiempo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "time.png")));
        lTiempo.setBounds(325, 90, 180, 48);
        add(lTiempo);
        lTiempo.setText("999");
        lTiempo.setFont(new Font("Arial", Font.BOLD, 28));

        matrizAleatoria = tablero.construirTablero(FILAS, COLUMNAS);
        
        for (int i = 0; i < btnJugadas.length; i++) {
            for (int j = 0; j < btnJugadas[i].length; j++) {
                //btnJugadas[i][j] = new JButton(defaultIcon);
                btnJugadas[i][j] = new JButton("NA");
                btnJugadas[i][j].setBounds(90 + 102 * j, 180 + 102 * i, 100, 100);
                btnJugadas[i][j].addActionListener(this);
                add(btnJugadas[i][j]);
            }
        }

        btnReiniciar = new JButton("Reiniciar Partida");
        btnReiniciar.setBounds(40, 600, 220, 48);
        add(btnReiniciar);
        btnReiniciar.setFont(new Font("Arial", Font.BOLD, 18));

        btnResultados = new JButton("Resultados");
        btnResultados.setBounds(310, 600, 220, 48);
        add(btnResultados);
        btnResultados.setFont(new Font("Arial", Font.BOLD, 18));

        btnRepetir = new JButton("Volver a Jugar");
        btnRepetir.setBounds(40, 665, 220, 48);
        add(btnRepetir);
        btnRepetir.setFont(new Font("Arial", Font.BOLD, 18));

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(310, 665, 220, 48);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));

        setSize(600, 770);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( ae.getSource() == btnReiniciar){
            
        }else {
            for (int i = 0; i < btnJugadas.length; i++) {
                for (int j = 0; j < btnJugadas[i].length; j++) {
                    if ( ae.getSource() == btnJugadas[i][j]){
                        //Aumentar la Cantidad de Jugadas Realizadas
                        lJugadas.setText(String.valueOf(++numJugadas));
                        
                        btnJugadas[i][j].setText(String.valueOf(matrizAleatoria[i][j]));
                        
                        if (numJugadas%2 == 0){
                            posSegundaJugada = new int[] {i,j};
                            
                            boolean pareja = tablero.analizarJugada(matrizAleatoria, posPrimeraJugada, posSegundaJugada);
                            
                            if (pareja){
                                btnJugadas[posPrimeraJugada[0]][posPrimeraJugada[1]].setEnabled(false);
                                btnJugadas[posPrimeraJugada[0]][posPrimeraJugada[1]].setOpaque(true);
                                btnJugadas[posSegundaJugada[0]][posSegundaJugada[1]].setEnabled(false);
                                btnJugadas[posSegundaJugada[0]][posSegundaJugada[1]].setOpaque(true);

                            }else{
                                btnJugadas[posPrimeraJugada[0]][posPrimeraJugada[1]].setText("NA");
                                btnJugadas[posSegundaJugada[0]][posSegundaJugada[1]].setText("NA");
                            }
                            
                            
                        }else{
                            posPrimeraJugada = new int[] {i,j};
                        }
                        
                        
                        
                    }
                }
            }
        }
    }

}
