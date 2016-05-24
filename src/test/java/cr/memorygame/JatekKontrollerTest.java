/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame;

import cr.memorygame.model.Jatekos;
import cr.memorygame.model.Nehezseg;
import cr.memorygame.model.Temak;
import cr.memorygame.model.Rekordok;
import cr.memorygame.model.Talalat;
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
public class JatekKontrollerTest {

    public JatekKontrollerTest() throws ParserConfigurationException, IOException, SAXException, TransformerException {

    }

    @Test
    public void Test() throws IOException, ParserConfigurationException, SAXException {
        ArrayList<String> names = new ArrayList();
        JatekKontroller g = new JatekKontroller(null);
        KepEleres k = new KepEleres("/img/allat/");
        Builder builder = new Builder(k, 10);

        assertEquals(builder.getParok_szama(), 10);
        assertEquals(builder.getKepeleres().getEleres(), "/img/allat");

        String nev = "nev";
        Nehezseg nehezseg = Nehezseg.Közepes;
        Temak tema = Temak.virag;
        Jatekos player = new Jatekos(nev, nehezseg, tema);

        assertEquals(player.getNev(), "nev");
        assertEquals(player.getNehezseg(), player.nehezseg.Közepes);
        assertEquals(player.getTema(), player.tema.virag);

        player.setNev("alma");
        player.setNehezseg(Nehezseg.Nehéz);
        player.setTema(Temak.virag);

        assertEquals("Helyes nev", true, player.getNev().equals("alma"));
        assertEquals("Helytelen nev", false, (!player.getNev().equals("alma")));

        assertEquals("Helyes nehezsegi fokozat", true, player.getNehezseg().equals(player.nehezseg.Nehéz));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getNehezseg().equals(player.nehezseg.Nehéz)));

        assertEquals("Helyes nehezsegi fokozat", true, player.getTema().equals(player.tema.virag));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getTema().equals(player.tema.virag)));

        builder.GameBuilder();
        builder.GameBuilder().lapokLetrehozasa(k, 10);
        assertEquals(20, builder.GameBuilder().lapok.size());

        Talalat t = new Talalat();

        builder.GameBuilder().talalatVan(t);

        assertEquals(false, builder.GameBuilder().talalatVan(t));
        assertEquals(true, t.UjTalalat("1.jpg"));
        assertEquals("1.jpg", t.getElsoKep());

        t.setMasodikKep("1.jpg");
        assertEquals("1.jpg", t.getMasodikKep());
        assertEquals(1, t.getTalalatSzama());

        assertEquals(false, t.helyesTalalat());

        names.add("alma");

        assertEquals(false, g.check("alma"));

        assertNull(g.getJatekos());
        assertNull(g.getKepEleres());
        assertNull(g.getKepEleres());

    }

    @Test
    public void Test2() {
        KepEleres kep = new KepEleres("/img/alma");
        int lapok_szama = 124;
        Builder builder = new Builder(kep, lapok_szama);

        assertEquals("Helyes eleres", true, builder.getKepeleres().getEleres().equals("/img/alma"));
        assertEquals("Helytelen eleres", false, (!builder.getKepeleres().getEleres().equals("/img/alma")));

        assertEquals("Helyes eleres", true, builder.getParok_szama() == 124);
        assertEquals("Helyes eleres", false, builder.getParok_szama() != 124);

    }
}
