/**
 * Main goal of this class is to run the application
 */
package core;

import gui.AdminLoginFrame;
import javax.swing.JOptionPane;
import service.Database;

/**
 *
 * @author ashik
 */
public class Main {

    private static final Database DATABASE = new Database();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            java.awt.EventQueue.invokeLater(() -> {

                new AdminLoginFrame(DATABASE).setVisible(true);
            });
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }
}
