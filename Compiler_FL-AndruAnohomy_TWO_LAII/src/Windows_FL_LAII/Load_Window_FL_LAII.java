package Windows_FL_LAII;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Load_Window_FL_LAII extends javax.swing.JFrame implements Runnable {

    
    private static final Logger LOG = Logger.getLogger(Load_Window_FL_LAII.class.getName());
    private static final long serialVersionUID = 2012201552509951L;
    private Thread loading;
    private static String a[] = {"Inicioando Librerias", "Cargando Imagen", "Localizando Perfil", "Verificado Memoria", "Estructurando Algoritmo", "Instalando Algoritmos ", "Creacion de Pantalla",
        "Manejo se Pizarra", "Verificando Hadwared", "Hadwared Verificados", "Lidrerias Actualizadas", "Imagen Previa", "Pefiles de Inicio Cargados", "Memoria Establecida",
        "Algoritmos Listos", "Pizarra Completa y Lista", "Iniciando Programa", "Ultima Verificacion", "Verificando", "Iniciado Ventana Principal", "Inicio Terminado", "Bienvenido"};
    private static String b[] = {"Cargando...", "Cargando..", "Cargando.", "Cargando..", "Cargando...", "Cargando..", "Cargando.", "Cargando..", "Cargando...", "Cargando..",
        "Cargando.", "Cargando..", "Cargando...", "Cargando..", "Cargando.", "Cargando..", "Cargando...", "Cargando..", "Cargando.", "Cargando..", "Cargando...",
        "Cargando.."};

    /**
     *
     */
    public Load_Window_FL_LAII() {

        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU - (2).png")).getImage());

    }

    @Override
    public void run() {

        int num = 0, num1 = 0;

        while (num < 2000) {

            try {

                this.setVisible(true);
                loadingBar.setValue(num);
                loadingBar.repaint();
                text2.setText(a[num1]);
                text1.setText(b[num1]);
                loading.sleep(250);

            } catch (InterruptedException ex) {

                Logger.getLogger(Load_Window_FL_LAII.class.getName()).log(Level.SEVERE, "Error de Ejeccion de la ventana de Carga");

            }

            num += 95;
            num1++;

        }

        this.dispose();

        new Beginning_Window_FL_LAII().setVisible(true);

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Load_Window_FL_LAII{" + '}';

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingBar = new javax.swing.JProgressBar(0,2000);
        jLabel2 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadingBar.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        loadingBar.setForeground(new java.awt.Color(0, 0, 0));
        loadingBar.setString("");
        loadingBar.setStringPainted(true);
        getContentPane().add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 480, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Proyecto Compilador 1.1 BETA TESCo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 270, -1));

        text2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        text2.setText("y");
        getContentPane().add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 160, -1));

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD, jLabel3.getFont().getSize()+53));
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Compilador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 380, 80));

        text1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        text1.setText("Cargando..");
        getContentPane().add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_FL_LAII/ANDRU.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 260));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JProgressBar loadingBar;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    // End of variables declaration//GEN-END:variables
}//clase
