/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
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

    private JComboBox selJugador;
    private JComboBox selDificultad;
    private static final String IMAGENES = "../media/imagenes/";
    private JLabel lLogo;
    private JLabel lSelJugador;
    private JLabel lSelDificultad;
    private JButton btnAgregarJugador;
    private JButton btnJugar;
    private JButton btnVolver;

    public ConfigPartidaUI() {
        
        setLayout(null);
        
        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 66);
        getContentPane().add(lLogo);
        
        lSelJugador=new JLabel("Seleccionar Jugador");
        lSelJugador.setBounds(50,100, 500, 35);
        lSelJugador.setFont(new Font("Arial", Font.BOLD, 20));
        add(lSelJugador);
        

        selJugador = new JComboBox();
        selJugador.setBounds(50, 140 , 500, 50);
        selJugador.setFont(new Font("Arial", Font.BOLD, 18));
        getContentPane().add(selJugador);
        selJugador.addItem("Cristian");
        selJugador.addItem("Laura");
        selJugador.addItem("Gustavo");
        
        btnAgregarJugador=new JButton("Agregar Jugador");
        btnAgregarJugador.setBounds(410,195, 150, 35);
        btnAgregarJugador.setFont(new Font("Arial", Font.BOLD, 15));
        btnAgregarJugador.setBackground(new Color(238, 238, 238));
        btnAgregarJugador.setBorder(null);
        //Evitar que al ser clikeado quede enmarcado
        btnAgregarJugador.setFocusPainted(false);
        btnAgregarJugador.setBorderPainted(false);
        add(btnAgregarJugador);

        lSelDificultad=new JLabel("Seleccionar Dificultad");
        lSelDificultad.setBounds(50,245, 500, 35);
        lSelDificultad.setFont(new Font("Arial", Font.BOLD, 20));
        selDificultad = new JComboBox();
        selDificultad.addItem("Facil");
        selDificultad.addItem("Medio");
        selDificultad.addItem("Dificil");
        add(lSelDificultad);
        
        selDificultad = new JComboBox();
        selDificultad.setBounds(50, 285 ,500, 50);
        getContentPane().add(selDificultad);

        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(50, 390, 500, 50);
        getContentPane().add(btnJugar);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
        btnJugar.addActionListener(this);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(50 , 460, 500, 50);
        getContentPane().add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);
        
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
