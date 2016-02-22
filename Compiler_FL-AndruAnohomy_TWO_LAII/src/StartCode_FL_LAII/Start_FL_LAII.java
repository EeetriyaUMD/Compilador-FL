package StartCode_FL_LAII;

import Windows_FL_LAII.Load_Window_FL_LAII;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Start_FL_LAII {

    private static final Logger LOG = Logger.getLogger(Start_FL_LAII.class.getName());
    private static final long serialVersionUID = 2012201552509950L;

    /**
     *
     */
    public Start_FL_LAII() {
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            LOG.info("Inicio del Compiler FL-AndruAnnohomy");

//            new Beginning_Window_FL_LAII().setVisible(true);
            new Thread(new Load_Window_FL_LAII()).start();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {

            Logger.getLogger(Start_FL_LAII.class.getName()).log(Level.SEVERE, "Error de Ejecucion");

        }

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Start_FL_LAII{" + '}';

    }

}
