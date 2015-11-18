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
 *
 * @author gusta
 */
public class PrincipalUI extends JFrame implements ActionListener {

    public static final String IMAGENES = "../media/imagenes/";

    private JLabel lLogo;
    private JButton btnJugar;
    private JButton btnRegistrar;
    private JButton btnResultados;
    private JButton btnCreditos;
    private JButton btnSalir;
    private Tablero tablero;

    //INSTANCIAR VENTANAS DE LA APLICACIÓN
    private ConfigPartidaUI confP;
    private CreditosUI cre;
    private JugadorUI jug;
    private ResultadosUI res;
    private Principal prinLog;

    public PrincipalUI() {
        prinLog = new Principal();
        cre = new CreditosUI(this);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
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

    public JugadorUI getJug() {
        return jug;
    }

    public void setJug(JugadorUI jug) {
        this.jug = jug;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public ResultadosUI getRes() {
        return res;
    }

    public void setRes(ResultadosUI res) {
        this.res = res;
    }

    public ConfigPartidaUI getConfP() {
        return confP;
    }

    public void setConfP(ConfigPartidaUI confP) {
        this.confP = confP;
    }

    public Principal getPrinLog() {
        return prinLog;
    }

    public void setPrinLog(Principal prinLog) {
        this.prinLog = prinLog;
    }

}
