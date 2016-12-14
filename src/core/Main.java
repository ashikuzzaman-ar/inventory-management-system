/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import gui.AdminLoginFrame;

/**
 *
 * @author ashik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AdminLoginFrame alf = new AdminLoginFrame();

        java.awt.EventQueue.invokeLater(() -> {
            
            alf.setVisible(true);
        });
    }
}
