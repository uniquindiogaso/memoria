package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 * Ésta Interfaz muestra en un tabla el mejor resultados de los jugadores
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class ResultadosUI extends JFrame implements ActionListener {

    //ATRIBUTOS
    private JLabel lLogo;
    private JLabel lResultados;

    private JButton btnVolver;
    private JButton btnJugar;

    private JTable lstResultados;
    private JScrollPane scrollTabla;

    private PrincipalUI pri;
    private ConfigPartidaUI conf;

    /**
     * Método constructor de la clase ResultadosUI
     *
     * @param pri objeto tipo PrincipalUI, que es la ventana principal de la
     * aplicación
     */
    public ResultadosUI(PrincipalUI pri) {
        this.pri = pri;
        this.conf = pri.getConfP();

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes utilizados en la ventana ResultadosUI
     */
    private void inicializarComponentes() {
        setTitle("Resultados ..: Paranoic Memory :..");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 620);
        setResizable(false);
        setLocationRelativeTo(null);

        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "LogoTablero.png")));
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

        btnVolver = new JButton(new ImageIcon(this.getClass().getResource(PrincipalUI.IMAGENES + "return.png")));
        btnVolver.setText("Volver");
        btnVolver.setBounds(310, 520, 220, 50);
        add(btnVolver);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 18));
        btnVolver.addActionListener(this);
    }

    /**
     * Gestor de eventos generados en la ventana
     *
     * @param ae - origen del evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnJugar) {
            conf = new ConfigPartidaUI(pri);
            conf.setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == btnVolver) {
            pri.setVisible(true);
            setVisible(false);
        }
    }

    /**
     * Actualiza la tabla con la información que está contenida en el ArrayList
     * de los jugadores
     */
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
