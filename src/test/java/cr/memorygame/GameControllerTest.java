/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame;

import cr.memorygame.model.Rekordok;
import cr.memorygame.model.XMLFeldolg;
import cr.memorygame.view.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;

/**
 *
 * @author roli
 */
public class GameControllerTest {

    public GameControllerTest() throws ParserConfigurationException, IOException, SAXException, TransformerException {

    }

    @Test
    public void testGetPlayer() throws IOException, ParserConfigurationException, SAXException {
        ArrayList<String> names = new ArrayList();
        GameController g = new GameController(null);
        KepEleres k = new KepEleres("kep");

        names.add("alma");

       // assertNull(g.getPlayer());
        assertEquals(false, g.check("alma"));
        assertEquals(true, g.check("proba"));

        String nev = "nev";
        Nehezseg nehezseg = Nehezseg.Közepes;
        Temak tema = Temak.virag;
        Player player = new Player(nev, nehezseg, tema);

        assertNull(g.getPlayer());
        assertNull(g.getKepEleres());
        assertNull(g.getKepEleres());

    }

}
/*
 @Test
 public void testStart() {
 }*/
