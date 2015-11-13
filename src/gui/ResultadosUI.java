/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author gusta
 */
public class ResultadosUI extends JFrame implements ActionListener {

    private JButton btnVolver;
    private JLabel lLogo;
    private JButton btnJugar;
    private JLabel lResultados;
    private JTable lstResultados;
    private PrincipalUI pri;
    private ConfigPartidaUI conf;
    private JScrollPane scrollTabla;

    private static final String IMAGENES = "../media/imagenes/";

    public ResultadosUI(PrincipalUI pri) {
        this.pri = pri;
        this.conf = pri.getConfP();

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

        actualizarTabla();

        btnJugar = new JButton("Jugar de nuevo");
        btnJugar.setBounds(60, 520, 220, 50);
        add(btnJugar);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
        btnJugar.addActionListener(this);

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(IMAGENES + "return.png")));
        btnVolver.setText("Volver");
        btnVolver.setBounds(310, 520, 220, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnJugar) {
            //Si aun no ha instanciado la ventana de Configuración
            //generar nueva instancia
            if (conf == null) {
                conf = new ConfigPartidaUI(pri);
            }
            conf.setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == btnVolver) {
            pri.setVisible(true);
            setVisible(false);
        }
    }

    public void actualizarTabla() {
        String datosJugadores[][] = pri.getPrinLog().listarResultados();
        lstResultados = new JTable(datosJugadores, new String[]{"Usuario", "Jugadas", "Tiempo"});
        lstResultados.setFont(new Font("Arial", Font.BOLD, 18));
        lstResultados.setRowHeight(20);

        //Cambiar Estilo a Encabezado
        JTableHeader encabezado = lstResultados.getTableHeader();
        encabezado.setPreferredSize(new Dimension(500, 32));
        encabezado.setFont(new Font("Arial", Font.BOLD, 24));
        //No permitir el desplazamiento del encabezado
        encabezado.setReorderingAllowed(false);

        JScrollPane scrollResultados = new JScrollPane(lstResultados);
        scrollResultados.setBounds(75, 150, 450, 350);
        add(scrollResultados);
    }

}
