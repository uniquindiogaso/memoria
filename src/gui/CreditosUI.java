package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Ésta Interfaz muestra los créditos de quienes realizaron en la aplicación
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class CreditosUI extends JFrame implements ActionListener {

    //ATRIBUTOS
    private JLabel lLogo;
    private JLabel lCreditos;

    private JButton btnVolver;

    private PrincipalUI pri;

    /**
     * Método constructor de la clase CreditosUI
     *
     * @param pri objeto tipo PrincipalUI, que es la ventana principal de la aplicación
     */
    public CreditosUI(PrincipalUI pri) {
        this.pri = pri;
        inicializarComponentes();
    }

    /**
     * Inicializa los componentes utilizados en la ventana CreditosUI
     */
    private void inicializarComponentes() {
        setTitle("Créditos ..: Paranoic Memory :..");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 600);
        setLocationRelativeTo(null);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 60);
        add(lLogo);

        lCreditos = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "creditos.gif")));
        lCreditos.setBounds(20, 150, 550, 307);
        add(lCreditos);

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "return.png")));
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
