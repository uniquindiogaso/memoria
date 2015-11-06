/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author gusta
 */
public class ConfigPartidaUI extends JFrame implements ActionListener {

    private JLabel lLogo;
    private JLabel lJugador;
    private JLabel lNivel;
    private JComboBox cbJugador;
    private JComboBox cbNivel;
    private JButton btnJugar;
    private JButton btnVolver;

    private static final String IMAGENES = "../media/imagenes/";

    public ConfigPartidaUI() {
        setLayout(null);
        setSize(600, 725);
        setLocationRelativeTo(null);
        inicializarComponetes();

    }

    public void inicializarComponetes() {
        setLayout(null);
        setSize(600, 600);
        setLocationRelativeTo(null);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 66);
        add(lLogo);

        lJugador = new JLabel("Jugador:");
        lJugador.setBounds(50, 150, 250, 30);
        add(lJugador);
        lJugador.setFont(new Font("Arial", Font.BOLD, 25));
        
        lNivel = new JLabel("Nivel:");
        lNivel.setBounds(50, 300, 250, 30);
        add(lNivel);
        lNivel.setFont(new Font("Arial", Font.BOLD, 25));

        cbJugador = new JComboBox();
        cbJugador.setBounds(50, 200, 350, 50);
        add(cbJugador);
        
        cbNivel = new JComboBox();
       cbNivel.setBounds(50, 350, 350, 50);
        add(cbNivel);
        
        btnJugar = new JButton(new ImageIcon(this.getClass().getResource(IMAGENES + "play.png")));
        btnJugar.setBounds(60, 450, 220, 48);
        add(btnJugar);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
        btnJugar.addActionListener(this);
    

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(IMAGENES + "return.png")));
        btnVolver.setBounds(310, 450, 220, 48);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
