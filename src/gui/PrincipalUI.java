/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author gusta
 */
public class PrincipalUI extends JFrame implements ActionListener{
    
    private JLabel lLogo;
    
    private JButton btnJugar;
    private JButton btnAgregar;
    private JButton btnResultados;
    private JButton btnCreditos;
    
    public PrincipalUI(){
        btnJugar= new JButton();
        
    }

    
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
