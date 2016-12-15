/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Admin;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ashik
 */
public class DatabaseTest {
    
    private final Database instance = new Database();
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of selectAdminFromUsername method, of class Database.
     */
    @Test
    public void testSelectAdminFromUsername() {
        System.out.println("selectAdminFromUsername");
        String username = "";
        Admin expResult = new Admin(2, "ashif", "ashif123", "ashif.rahaman@hotmail.com", "master");
        Admin result = instance.selectAdminFromUsername(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of selectMasterAdmin method, of class Database.
     */
    @Test
    public void testSelectMasterAdmin() {
        System.out.println("selectMasterAdmin");
        Admin expResult = new Admin(2, "ashif", "ashif123", "ashif.rahaman@hotmail.com", "master");
        Admin result = instance.selectMasterAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertNewAdmin method, of class Database.
     */
    @Test
    public void testInsertNewAdmin() {
        System.out.println("insertNewAdmin");
        Admin admin = new Admin("ashik", "ashik123", "ashikuzzaman.ar@gmail.com", "admin");
        boolean expResult = false;
        boolean result = instance.insertNewAdmin(admin);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class Database.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
