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

/**
 *
 * @author gusta
 */
public class ResultadosUI extends JFrame implements ActionListener {

    private JButton btnVolver;
    private JLabel lLogo;
    private JButton btnJugar;
    private JLabel lResultados;
    private JList lstResultados;

    private static final String IMAGENES = "../media/imagenes/";

    public ResultadosUI() {

        setTitle("Resultados");
        setLayout(null);
        setSize(600, 620);
        setResizable(false);
        setLocationRelativeTo(null);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 60);
        add(lLogo);

        lResultados = new JLabel("RECORDS");
        lResultados.setBounds(200, 100, 200, 40);
        lResultados.setFont(new Font("Arial", Font.BOLD, 28));
        add(lResultados);

        lstResultados = new JList();
        lstResultados.setBounds(75, 150, 450, 350);
        lstResultados.setBackground(Color.darkGray);
        add(lstResultados);

        btnJugar = new JButton("Jugar de nuevo");
        btnJugar.setBounds(60, 520, 220, 50);
        add(btnJugar);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(IMAGENES + "return.png")));
        btnVolver.setText("Volver");
        btnVolver.setBounds(310, 520, 220, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
