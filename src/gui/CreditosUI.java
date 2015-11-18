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
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 */
public class CreditosUI extends JFrame implements ActionListener {

    //ATRIBUTOS
    private JLabel lLogo;
    private JLabel lCreditos;

    private JButton btnVolver;

    private PrincipalUI pri;

    //MÉTODO CONSTRUCTOR
    public CreditosUI(PrincipalUI pri) {
        this.pri = pri;
        inicializarComponentes();
    }

    //INICIALIZACIÓN DE COMPONENTES
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
