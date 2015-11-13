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

/**
 *
 * @author gusta
 */
public class CreditosUI extends JFrame implements ActionListener {

    private JButton btnVolver;
    private JLabel lLogo;
    private JLabel lCreditos;
    private PrincipalUI pri;

    private static final String IMAGENES = "../media/imagenes/";

    public CreditosUI(PrincipalUI pri) {

        this.pri = pri;

        setTitle("Créditos");
        setLayout(null);
        setResizable(false);
        setSize(600, 600);
        setLocationRelativeTo(null);

        lCreditos = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "creditos.gif")));
        lCreditos.setBounds(20, 150, 550, 307);
        add(lCreditos);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 60);
        add(lLogo);

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(IMAGENES + "return.png")));
        btnVolver.setText("Menu Principal");
        btnVolver.setBounds(175, 475, 250, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        pri.setVisible(true);
        setVisible(false);
    }
}
