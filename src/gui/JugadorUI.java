package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

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
    private JTable lstJugadores;
    private JScrollPane scrollTabla;

    private PrincipalUI pri;

    public JugadorUI(PrincipalUI pri) {
        this.pri = pri;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setTitle("Agregar Jugador ..: Paranoic Memory :..");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "LogoTablero.png")));
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

        //actualizarTabla();
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(60, 600, 220, 50);
        add(btnAgregar);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
        btnAgregar.addActionListener(this);

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "return.png")));
        btnVolver.setText("Volver");
        btnVolver.setBounds(310, 600, 220, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);

        cmpCodigo.setText(String.valueOf(pri.getPrinLog().getJugadores().size() + 1));
        cmpCodigo.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAgregar) {
            if (!cmpNombre.getText().isEmpty()) {
                if (pri.getPrinLog().agregarJugador(cmpNombre.getText(), Integer.valueOf(cmpCodigo.getText()))) {
                    actualizarTabla();
                    cmpCodigo.setText(String.valueOf(pri.getPrinLog().getJugadores().size() + 1));
                    cmpNombre.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para registrar el jugador se debe de digitar nombre de usuario", "Información Incompleta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            pri.setVisible(true);
            setVisible(false);
        }

    }

    public void actualizarTabla() {
        String datosJugadores[][] = pri.getPrinLog().listarJugadores();

        lstJugadores = new JTable(datosJugadores, new String[]{"Usuario", "Jugadas", "Tiempo"});
        lstJugadores.setFont(new Font("Arial", Font.BOLD, 18));
        lstJugadores.setRowHeight(20);

        //Cambiar Estilo a Encabezado
        JTableHeader encabezado = lstJugadores.getTableHeader();
        encabezado.setPreferredSize(new Dimension(500, 32));
        encabezado.setFont(new Font("Arial", Font.BOLD, 24));
        //No permitir el desplazamiento del encabezado
        encabezado.setReorderingAllowed(false);

        scrollTabla = new JScrollPane(lstJugadores);
        scrollTabla.setBounds(50, 280, 500, 300);
        getContentPane().add(scrollTabla);

    }

}
