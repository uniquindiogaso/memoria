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
import javax.swing.JFrame;
import javax.swing.JLabel;
import logica.Tablero;

/**
 *
 * @author gusta
 */
public class PrincipalUI extends JFrame implements ActionListener {

    private static final String IMAGENES = "../media/imagenes/";
    private JLabel lLogo;
    private JButton btnJugar;
    private JButton btnRegistrar;
    private JButton btnResultados;
    private JButton btnCreditos;
    private JButton btnSalir;
    private Tablero tablero;

    public PrincipalUI() {
        getContentPane().setLayout(null);

        tablero = new Tablero();
        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 66);
        getContentPane().add(lLogo);

        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(175, 120, 250, 50);
        getContentPane().add(btnJugar);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
        btnJugar.addActionListener(this);

        btnRegistrar = new JButton("Agregar Jugador");
        btnRegistrar.setBounds(175, 200, 250, 50);
        getContentPane().add(btnRegistrar);
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrar.addActionListener(this);

        btnResultados = new JButton("Resultados");
        btnResultados.setBounds(175, 280, 250, 50);
        getContentPane().add(btnResultados);
        btnResultados.setFont(new Font("Arial", Font.BOLD, 18));
        btnResultados.addActionListener(this);

        btnCreditos = new JButton("Creditos");
        btnCreditos.setBounds(175, 360, 250, 50);
        getContentPane().add(btnCreditos);
        btnCreditos.setFont(new Font("Arial", Font.BOLD, 18));
        btnCreditos.addActionListener(this);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(175, 440, 250, 50);
        getContentPane().add(btnSalir);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 18));
        btnSalir.addActionListener(this);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnJugar) {
            setVisible(false);

        }

    }

}
