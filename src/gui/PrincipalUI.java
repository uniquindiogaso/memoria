package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Principal;
import logica.Tablero;

/**
 * Ésta es la Interfaz principal del juego que contiene las instancias a todos
 * los menús de la aplicación
 *
 * @author Cristian Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class PrincipalUI extends JFrame implements ActionListener {

    // ATRIBUTOS
    private JLabel lLogo;
    private JButton btnJugar;
    private JButton btnRegistrar;
    private JButton btnResultados;
    private JButton btnCreditos;
    private JButton btnSalir;
    private Tablero tablero;

    // Constante que guarda la ruta que contiene las imagenes utilizadas en la aplicación
    public static final String IMAGENES = "../media/imagenes/";

    //INSTANCIAR VENTANAS DE LA APLICACIÓN
    private ConfigPartidaUI confP;
    private CreditosUI cre;
    private JugadorUI jug;
    private ResultadosUI res;
    private Principal prinLog;

    /**
     * Método constructor de la clase PrincipalUI
     */
    public PrincipalUI() {
        prinLog = new Principal();
        cre = new CreditosUI(this);

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes utilizados en la ventana PrincipalUI
     */
    private void inicializarComponentes() {
        setTitle("Menú Principal ..: Paranoic Memory :..");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        tablero = new Tablero();
        lLogo = new JLabel(new ImageIcon(this.getClass().getResource(IMAGENES + "LogoTablero.png")));
        lLogo.setBounds(0, 5, 600, 66);
        add(lLogo);

        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(175, 120, 250, 50);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
        btnJugar.addActionListener(this);
        add(btnJugar);

        btnRegistrar = new JButton("Agregar Jugador");
        btnRegistrar.setBounds(175, 200, 250, 50);
        add(btnRegistrar);
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrar.addActionListener(this);

        btnResultados = new JButton("Resultados");
        btnResultados.setBounds(175, 280, 250, 50);
        add(btnResultados);
        btnResultados.setFont(new Font("Arial", Font.BOLD, 18));
        btnResultados.addActionListener(this);

        btnCreditos = new JButton("Créditos");
        btnCreditos.setBounds(175, 360, 250, 50);
        add(btnCreditos);
        btnCreditos.setFont(new Font("Arial", Font.BOLD, 18));
        btnCreditos.addActionListener(this);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(175, 440, 250, 50);
        add(btnSalir);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 18));
        btnSalir.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnJugar) {
            confP = new ConfigPartidaUI(this);
            confP.setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == btnRegistrar) {
            this.jug = new JugadorUI(this);
            jug.setVisible(true);
            jug.actualizarTabla();
            setVisible(false);
        } else if (ae.getSource() == btnResultados) {
            res = new ResultadosUI(this);
            res.setVisible(true);
            setVisible(false);

        } else if (ae.getSource() == btnCreditos) {
            cre.setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == btnSalir) {
            JOptionPane.showMessageDialog(null, "¡Hasta Luego!");
            System.exit(0);

        }
    }

    //MÉTODOS GETTERS AND SETTERS
    /**
     * Método get de JugadorUI
     *
     * @return jug el objeto de tipo JugadorUI
     */
    public JugadorUI getJug() {
        return jug;
    }

    /**
     * Método set de JugadorUI
     *
     * @param jug el objeto de tipo JugadorUI
     */
    public void setJug(JugadorUI jug) {
        this.jug = jug;
    }

    /**
     * Método get de Tablero
     *
     * @return tablero el objeto de tipo Tablero, en el paquete de logica
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Método set de tablero
     *
     * @param tablero el objeto de tipo Tablero, en el paquete de logica
     *
     */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Método get de ResultadosUI
     *
     * @return res el objeto tipo ResultadosUI
     */
    public ResultadosUI getRes() {
        return res;
    }

    /**
     * Método set de ResultadosUI
     *
     * @param res el objeto tipo ResultadosUI
     */
    public void setRes(ResultadosUI res) {
        this.res = res;
    }

    /**
     * Método get de configurarPartidaUI
     *
     * @return confP el objeto tipo ConfigPartidaUI
     */
    public ConfigPartidaUI getConfP() {
        return confP;
    }

    /**
     * Método set de configurarPartidaUI
     *
     * @param confP el objeto tipo ConfigPartidaUI
     */
    public void setConfP(ConfigPartidaUI confP) {
        this.confP = confP;
    }

    /**
     * Método get de Principal - lógica
     *
     * @return prinLog el objeto tipo Principal, en el paquete logica
     */
    public Principal getPrinLog() {
        return prinLog;
    }

    /**
     * Método set de Principal - lógica
     *
     * @param prinLog el objeto tipo Principal, en el paquete logica
     */
    public void setPrinLog(Principal prinLog) {
        this.prinLog = prinLog;
    }

}
