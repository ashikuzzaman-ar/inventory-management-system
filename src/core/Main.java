/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import gui.AdminLoginFrame;
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

        AdminLoginFrame alf = new AdminLoginFrame(DATABASE);

        java.awt.EventQueue.invokeLater(() -> {

            alf.setVisible(true);
        });
    }
}
