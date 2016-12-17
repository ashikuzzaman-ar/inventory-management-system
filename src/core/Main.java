/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import gui.HomeFrame;
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

//            new AdminLoginFrame(DATABASE).setVisible(true);
                new HomeFrame(DATABASE).setVisible(true);
            });
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
