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
import javax.swing.JTextField;

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

    private static final String IMAGENES = "../media/imagenes/";

    public JugadorUI() {

        setTitle("Agregar Jugador");
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(600, 700);
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
        
        cmpCodigo=new JTextField();
        //cmpCodigo.setBounds(150,);
        

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(60, 600, 220, 50);
        add(btnAgregar);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(IMAGENES + "return.png")));
        btnVolver.setText("Volver");
        btnVolver.setBounds(310, 600, 220, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
