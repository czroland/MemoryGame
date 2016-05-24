/*
 * Copyright (C) 2016 Czégényi Roland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cr.memorygame;

import cr.memorygame.model.RekordLista;
import cr.memorygame.model.Rekordok;
import cr.memorygame.model.XMLFeldolg;
import cr.memorygame.model.Jatekos;
import cr.memorygame.view.JatekNezetKontroller;
import cr.memorygame.view.Main;
import static cr.memorygame.view.Main.logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 * A fő kontroller osztály.
 */
public class JatekKontroller {

    private JatekNezetKontroller nezet;
    private Main mainApp;
    private Jatekos jatekos;
    private KepEleres kep;
    private Rekordok rek;
    private XMLFeldolg feld;

    /**
     * Konstruktor, amely létrehoz egy <code>GameController</code>-t reprezentáló
     * objektumot.
     *
     * @param mainApp hivatkozik a {@link cr.memorygame.view.Main} osztályra.
     */
    public JatekKontroller(Main mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Visszaadja a játékost.
     *
     * @return a player
     */
    public Jatekos getJatekos() {
        return jatekos;
    }

    /**
     * Beállitja az elérési mappát.
     *
     * @param kep a {@link cr.memorygame.model.Temak} -ból választottnak megfelelően
     * beállítja a mappát.
     */
    public void kepeleresInicializalasa(KepEleres kep) {
        this.kep = kep;
        kep.setEleres("/img/" + jatekos.getTema() + "/");
    }

    /**
     * Visszaadja a kép elérését.
     *
     * @return kep
     */
    public KepEleres getKepEleres() {
        return kep;
    }

    /**
     * Beállitja a játékost.
     *
     * @param jatekos a játék egy játékosa
     */
    public void jatekosInicializalas(Jatekos jatekos) {
        this.jatekos = jatekos;
    }

    /**
     * Ellenőrzi, hogy a játékos által megadott név szerepel-e az adatbázisban.
     *
     * @param nev a játékos által megadott <code>nev</code> név
     * @return megfelelő-e a név, avagy nem
     * @throws IOException hiba a fájlelérés során
     * @throws ParserConfigurationException hiba a feldolgozás során
     * @throws SAXException hiba az adatbázisselérés során
     */
    public boolean check(String nev) throws IOException, ParserConfigurationException, SAXException {
        logger.info(nev + " név ellenőrzése");
        xmlFajlLetrehozasa();


        ArrayList<String> nevek = new RekordLista().getNames();

        if (nevek.contains(nevek)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * XML fájl létrehozása, amennyiben az nem létezik. A <code>check()</code>
     * metódus hívja meg. A fájlt a home könyvtárban hozzuk létre.
     *
     * @throws IOException hiba a fájlelérés során
     * @throws ParserConfigurationException hiba a feldolgozás során
     * @throws SAXException hiba az adatbázisselérés során
     */
    public void xmlFajlLetrehozasa() throws IOException, ParserConfigurationException, SAXException {
        String filepath = System.getProperty("user.home") + File.separator;

        File xmlfile = new File(filepath + "memorygame.xml");

        if (xmlfile.exists()) {
            logger.info("az XML file letezik");
        } else {
            logger.info("az XML file nem letezik, letrehozzuk az user.home -ban windowson nem volt tesztelve");
            xmlfile.createNewFile();

            FileWriter fw = new FileWriter(xmlfile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            logger.info("fejlec beirasa");
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            bw.newLine();

            logger.info("gyokerelem ketrehozasa");
            bw.write("<alma>");
            bw.write("</alma>");

            bw.close();
        }

    }

    /**
     * A játék végeztével a {@link cr.memorygame.model.XMLFeldolg}
     * <code>addNewData()</code> meghívásával hozzáadja a játékos
     * <code>rekk</code> rekordját az XML fájlhoz. Majd a
     * {@link cr.memorygame.model.XMLFeldolg} <code>listData</code> mehhívásával
     * kiolvassa az adatokat.
     *
     * @param rekk a {@link cr.memorygame.model.Rekordok} egy objektuma
     * @throws ParserConfigurationException hiba a feldolgozás során
     * @throws IOException hiba a fájlelérés során
     * @throws SAXException hiba az adatbázisselérés során
     * @throws TransformerException formázási hiba
     */
    public void XMLFrissitess(Rekordok rekk) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        XMLFeldolg feld = new XMLFeldolg();

        feld.addNewData(rekk);
    }

    /**
     * Beállitja a játék nézetét.
     *
     * @param view referencia a view kontrollerre.
     */
    public void nezetBeallitasa(JatekNezetKontroller nezet) {
        logger.info(" nézet beállítása");

        this.nezet = nezet;
        

    }

    /**
     * Elindítja a játékot.
     */
    public void start() {
        mainApp.jatek();
    }
}
