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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import logica.Principal;

/**
 *
 * @author gusta
 */
public class JugadorUI extends JFrame implements ActionListener {

    private JButton btnVolver;
    private JButton btnAgregar;
    private JLabel lNombre;
    private JLabel lCodigo;
    private JLabel lLogo;
    private JTextField cmpCodigo;
    private JTextField cmpNombre;
    private JLabel lJugadores;
    private JList lstJugadores;
    private static final String IMAGENES = "../media/imagenes/";

    private PrincipalUI pri;

    public JugadorUI(PrincipalUI pri) {

        this.pri = pri;

        setLayout(null);
        setTitle("Agregar Jugador");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 60);
        add(lLogo);

        lCodigo = new JLabel("Código:");
        lCodigo.setBounds(50, 100, 120, 35);
        lCodigo.setFont(new Font("Arial", Font.BOLD, 28));
        add(lCodigo);

        lNombre = new JLabel("Nombre:");
        lNombre.setBounds(50, 170, 120, 35);
        lNombre.setFont(new Font("Arial", Font.BOLD, 28));
        add(lNombre);

        cmpCodigo = new JTextField();
        cmpCodigo.setBounds(190, 100, 280, 35);
        add(cmpCodigo);

        cmpNombre = new JTextField();
        cmpNombre.setBounds(190, 170, 280, 35);
        add(cmpNombre);

        lJugadores = new JLabel("Jugadores Registrados");
        lJugadores.setBounds(50, 245, 300, 35);
        lJugadores.setFont(new Font("Arial", Font.BOLD, 20));
        add(lJugadores);

        lstJugadores = new JList();
        lstJugadores.setBounds(50, 280, 500, 300);
        lstJugadores.setBackground(Color.darkGray);
        add(lstJugadores
        );

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(60, 600, 220, 50);
        add(btnAgregar);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
        btnAgregar.addActionListener(this);

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(IMAGENES + "return.png")));
        btnVolver.setText("Volver");
        btnVolver.setBounds(310, 600, 220, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAgregar) {
            pri.getPrinLog().agregarJugador(cmpNombre.getText(), Integer.valueOf(cmpCodigo.getText()));
            System.out.println("Jugador:" + pri.getPrinLog().getJugadores().size());
        } else {
            pri.setVisible(true);
            setVisible(false);

        }

    }

}
