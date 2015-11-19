package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Jugador;

/**
 * Ésta Interfaz permite configurar la partida, determinando el jugador y la dificultad del juego
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class ConfigPartidaUI extends JFrame implements ActionListener {

    //ATRIBUTOS
    private JLabel lLogo;
    private JLabel lSelJugador;
    private JLabel lSelDificultad;

    private JComboBox selJugador;
    private JComboBox selDificultad;

    private JButton btnAgregarJugador;
    private JButton btnJugar;
    private JButton btnVolver;

    //INSTANCIAR VENTANAS
    private PrincipalUI pri;
    private TableroUI tab;
    private JugadorUI jug;

    // Listado de jugadores
    private ArrayList<Jugador> jugadores;

    
    /**
     * Método constructor de la clase ConfigPartidaUI
     * @param pri objeto tipo PrincipalUI, que es la ventana principal de la aplicación
     */
    public ConfigPartidaUI(PrincipalUI pri) {
        this.pri = pri;

        inicializarComponentes();
        actualizarListJugadores();

    }

    /**
     * Inicializa los componentes utilizados en la ventana ConfigPartidaUI
     */
    private void inicializarComponentes() {
        setLayout(null);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Seleccione Jugador y Nivel de Dificultad ..: Paranoic Memory :..");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 66);
        getContentPane().add(lLogo);

        lSelJugador = new JLabel("Seleccionar Jugador");
        lSelJugador.setBounds(50, 100, 500, 35);
        lSelJugador.setFont(new Font("Arial", Font.BOLD, 20));
        add(lSelJugador);

        lSelDificultad = new JLabel("Seleccionar Dificultad");
        lSelDificultad.setBounds(50, 245, 500, 35);
        lSelDificultad.setFont(new Font("Arial", Font.BOLD, 20));

        selJugador = new JComboBox();
        selJugador.setBounds(50, 140, 500, 50);
        selJugador.setFont(new Font("Arial", Font.BOLD, 18));
        add(selJugador);

        selDificultad = new JComboBox();
        selDificultad.setFont(new Font("Arial", Font.BOLD, 18));
        selDificultad.addItem("Facil");
        selDificultad.addItem("Medio");
        selDificultad.addItem("Dificil");
        add(lSelDificultad);
        selDificultad.setBounds(50, 285, 500, 50);
        getContentPane().add(selDificultad);
        
        btnAgregarJugador = new JButton("Agregar Jugador");
        btnAgregarJugador.setBounds(410, 195, 150, 35);
        btnAgregarJugador.setFont(new Font("Arial", Font.BOLD, 15));
        btnAgregarJugador.setBackground(new Color(238, 238, 238));
        btnAgregarJugador.setBorder(null);
        //Evitar que al ser clikeado quede enmarcado
        btnAgregarJugador.setFocusPainted(false);
        btnAgregarJugador.setBorderPainted(false);
        add(btnAgregarJugador);
        btnAgregarJugador.addActionListener(this);

        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(50, 390, 500, 50);
        add(btnJugar);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
        btnJugar.addActionListener(this);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(50, 460, 500, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAgregarJugador) {
            jug = new JugadorUI(pri);
            jug.setVisible(true);
            jug.actualizarTabla();
            setVisible(false);
        } else if (ae.getSource() == btnJugar) {
            if (selJugador.getItemCount() > 0) {
                tab = new TableroUI(pri, pri.getPrinLog().getJugadores().get(selJugador.getSelectedIndex()).getCodigo(), selDificultad.getSelectedItem().toString());
                tab.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Debe crear un usuario para poder jugar.");
            }
        } else if (ae.getSource() == btnVolver) {
            pri.setVisible(true);
            setVisible(false);
        }
    }

    /**
     * Agrega a los jugadores al combobox de la ventana
     */
    public void actualizarListJugadores() {
        for (Jugador j : pri.getPrinLog().getJugadores()) {
            selJugador.addItem(j);
        }
    }

}
