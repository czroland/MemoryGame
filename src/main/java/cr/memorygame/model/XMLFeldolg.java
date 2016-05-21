/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame.model;

import java.io.File;
import static cr.memorygame.view.Main.logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
 *
 * @author roli
 */
public class XMLFeldolg {

    public XMLFeldolg() {
    }

    public String createXMLFile() throws IOException, ParserConfigurationException, SAXException {
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

        return filepath + "memorygame.xml";

    }

    public void addNewData(Rekordok rekord) throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(createXMLFile());

        Element gyoker = doc.getDocumentElement();
        Element ujrekord = doc.createElement("rekord");

        Element ujnev = doc.createElement("nev");
        ujnev.setTextContent(rekord.getNev());
        ujrekord.appendChild(ujnev);

        Element ujhelyestipp = doc.createElement("helyes");
        ujhelyestipp.setTextContent(Integer.toString(rekord.getHelyesTipp()));
        ujrekord.appendChild(ujnev);

        Element ujhelytelen = doc.createElement("helytelen");
        ujhelytelen.setTextContent(Integer.toString(rekord.getHelytelenTipp()));
        ujrekord.appendChild(ujhelytelen);

        gyoker.appendChild(ujrekord);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        File file = new File(createXMLFile());
        StreamResult result = new StreamResult(file);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);

    }

    public List<Rekordok> listData() throws ParserConfigurationException, SAXException, IOException {
        List<Rekordok> rekordok = new ArrayList<>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(createXMLFile());

        doc.getDocumentElement().normalize();
        
         NodeList rekordList = doc.getElementsByTagName("rekord");
         
         for (int i = 0; i < rekordList.getLength(); i++) {
                Element element2 = (Element) rekordList.item(i);
                
                rekordok.add(new Rekordok(element2.getElementsByTagName("nev").item(0).getTextContent(),
                                           Integer.parseInt(element2.getElementsByTagName("helyes").item(0).getTextContent()),
                                            Integer.parseInt(element2.getElementsByTagName("helytelen").item(0).getTextContent())                
                ));
         }

        return rekordok;
    }
}
