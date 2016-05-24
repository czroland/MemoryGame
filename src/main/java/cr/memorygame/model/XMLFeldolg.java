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
package cr.memorygame.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XMLFeldolgozó osztály.
 */
public class XMLFeldolg {

    /**
     * Új adat hozzádasa az XML file-hoz, amennyiben a játék véget ért.
     *
     * @param rekord a {@link cr.memorygame.model.Rekordok} egy példánya
     * @throws ParserConfigurationException hiba a feldolgozás során
     * @throws IOException hiba a fájlelérés során
     * @throws SAXException hiba az adatbázisselérés során
     * @throws TransformerConfigurationException hiba az adatformázás során
     * @throws TransformerException hiba az adatformázás során
     */
    public void addNewData(Rekordok rekord) throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException, TransformerException {
        String filepath = System.getProperty("user.home") + File.separator;

        File xmlfile = new File(filepath + "memorygame.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(filepath + "memorygame.xml");

        Element gyoker = doc.getDocumentElement();
        Element ujrekord = doc.createElement("rekord");

        Element ujnev = doc.createElement("nev");
        ujnev.setTextContent(rekord.getNev());
        ujrekord.appendChild(ujnev);

        Element ujhelyestipp = doc.createElement("helyes");
        ujhelyestipp.setTextContent(Integer.toString(rekord.getHelyesTipp()));
        ujrekord.appendChild(ujhelyestipp);

        Element ujhelytelen = doc.createElement("helytelen");
        ujhelytelen.setTextContent(Integer.toString(rekord.getHelytelenTipp()));
        ujrekord.appendChild(ujhelytelen);

        gyoker.appendChild(ujrekord);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        File file = new File(filepath + "memorygame.xml");
        StreamResult result = new StreamResult(file);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);

    }

    /**
     * Az adatok kilistázása az adatbázisból.
     *
     * @return a {@link cr.memorygame.model.Rekordok} egy rekordok nevű
     * példánya, vagyis nev, helyes helytelen pontok
     * @throws ParserConfigurationException hiba a feldolgozás során
     * @throws SAXException hiba az adatbázisselérés során
     * @throws IOException hiba a fájlelérés során
     */
    public static List<Rekordok> listData() throws ParserConfigurationException, SAXException, IOException {
        List<Rekordok> rekordok = new ArrayList<>();
        String filepath = System.getProperty("user.home") + File.separator;

        File xmlfile = new File(filepath + "memorygame.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(filepath + "memorygame.xml");

        doc.getDocumentElement().normalize();

        NodeList rekordList = doc.getElementsByTagName("rekord");

        for (int i = 0; i < rekordList.getLength(); i++) {
            Element element2 = (Element) rekordList.item(i);
            // System.out.println(element2.getElementsByTagName("nev").item(0).getTextContent());

            rekordok.add(new Rekordok(element2.getElementsByTagName("nev").item(0).getTextContent(),
                    Integer.parseInt(element2.getElementsByTagName("helyes").item(0).getTextContent()),
                    Integer.parseInt(element2.getElementsByTagName("helytelen").item(0).getTextContent())
            ));
        }
         Collections.sort(rekordok, Rekordok.rendez);
        return rekordok;
    }
}
