/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame.model;

import java.io.File;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author roli
 */
public class XMLFeldolgTest {

    @Test
    public void testAddNewData() throws Exception {

        String filepath = System.getProperty("user.home") + File.separator;

        File xmlfile = new File(filepath + "memorygame.xml");

        Rekordok rek = new Rekordok("alma", 1, 2);
        XMLFeldolg feld = new XMLFeldolg();
        feld.addNewData(rek);
        feld.listData();

        assertNotEquals("", feld.listData());

        assertEquals("alma", rek.getNev());
        assertEquals(1, rek.getHelyesTipp());
        assertEquals(2, rek.getHelytelenTipp());

        rek.setNev("alma");
        rek.setHelyesTipp(2);
        rek.setHelytelenTipp(2);
        assertEquals("alma", rek.getNev());
        assertEquals(2, rek.getHelyesTipp());
        assertEquals(2, rek.getHelytelenTipp());
        
        
       
        
        

    }

}
