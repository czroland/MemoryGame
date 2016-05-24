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
package cr.memorygame.view;

import cr.memorygame.Builder;
import javafx.fxml.FXML;
import cr.memorygame.JatekKontroller;
import cr.memorygame.model.Jatek;
import cr.memorygame.KepEleres;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.application.Platform;

import cr.memorygame.model.Jatekos;
import cr.memorygame.model.Talalat;
import cr.memorygame.model.RekListazasa;
import cr.memorygame.model.Rekordok;
import cr.memorygame.model.XMLFeldolg;
import static cr.memorygame.view.Main.logger;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author roli
 */
public class JatekNezetKontroller extends NezetKontroller {

    private static final int lapokSoronkent = 4;
    private final EventHandler imageViewClickEventHandler = clickEventHandler();
    Jatek jatek;
    Talalat talalat;
    Jatekos jatekos;
    @FXML
    private GridPane pane;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label jneve;

    @FXML
    private TableView reklista;

    /* @FXML
     private TableColumn nev;
     @FXML
     private TableColumn helyes;
     @FXML
     private TableColumn helytelen;*/
    @FXML
    private Label tema_neve;

    @FXML
    private Label nehezseg_neve;

    @FXML
    private Label ht;
    @FXML
    private Label nht;
    String kepeleres;
    KepEleres kep;
    Rekordok rek;

    int talalat_szama = 0;
    int teves_talalat = 0;
    public Image hatter = new Image(this.getClass().getResourceAsStream("/bg.jpg"));

    @Override
    public void jatekKontrollerBeallitasa(JatekKontroller jatekkontr) {
        this.jatekkontr = jatekkontr;
        jatekkontr.nezetBeallitasa(this);

        adatok();
        felulet();

    }

    public String adatok() {

        jneve.setText(jatekkontr.getJatekos().getNev());
        nehezseg_neve.setText(jatekkontr.getJatekos().getNehezseg().toString());
        tema_neve.setText(jatekkontr.getJatekos().getTema().toString());

        if (jatekkontr.getJatekos().getTema().toString().equals("Allat")) {
            kepeleres = "/img/allat/";

        }
        if (jatekkontr.getJatekos().getTema().toString().equals("Gyümölcs")) {
            kepeleres = "/img/gyumolcs/";
        }
        if (jatekkontr.getJatekos().getTema().toString().equals("Virág")) {
            kepeleres = "/img/virag/";
        }

        return kepeleres;

    }

    public void felulet() {

        for (Node gyerek : pane.getChildren()) {
            gyerek.removeEventHandler(MouseEvent.MOUSE_CLICKED, imageViewClickEventHandler);
        }
        pane.getChildren().clear();
        kep = new KepEleres(jatekkontr.getKepEleres().getEleres() + "/");

        jatek = new Builder(kep, 10).GameBuilder();

        logger.info("ImageView -ok létrehozása");

        ujImageViewekLetrehozasa(20);
        talalat = new Talalat();

    }

    private void ujImageViewekLetrehozasa(int meret) {
        int sorIndex = 0;
        int oszlopIndex = 0;

        for (int lapIndex = 0; lapIndex < meret; lapIndex++) {
            ImageView imageView = new ImageView(hatter);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            imageView.setEffect(new DropShadow(5, Color.BLACK));

            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, imageViewClickEventHandler);
            pane.add(imageView, sorIndex, oszlopIndex);
            sorIndex++;
            if (sorIndex % lapokSoronkent == 0) {
                oszlopIndex++;
                sorIndex = 0;
            }
        }
    }

    private EventHandler clickEventHandler() {
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                if (!(event.getSource() instanceof ImageView)) {
                    return;
                }

                ImageView klikkeltImageView = (ImageView) event.getSource();

                int oszlop = GridPane.getColumnIndex(klikkeltImageView);
                int sor = GridPane.getRowIndex(klikkeltImageView);

                int valasztottLapIndex = sor * lapokSoronkent + oszlop;
                logger.info(jatek.getLapIndex(valasztottLapIndex) + "kép lett kiválasztva");

                //System.out.println(selectedCardIndex+"korte");
                if (talalat.UjTalalat(jatek.getLapIndex(valasztottLapIndex))) {
                    klikkeltImageView.setImage(new Image(jatek.getLapIndex(valasztottLapIndex)));

                }

                if (talalat.helyesTalalat()) {

                    if (jatek.talalatVan(talalat)) {
                        logger.info("a kiválasztott képek egyeznek");
                        talalat_szama++;

                        for (int i = 0; i < 20; i++) {
                            if (jatek.getLapIndex(i).equals(talalat.getElsoKep()) && jatek.getLapIndex(i).equals(talalat.getMasodikKep())) {
                                pane.getChildren().get(i).removeEventHandler(MouseEvent.MOUSE_CLICKED, imageViewClickEventHandler);
                                logger.info(i + ".ik lap mostmár nem klikkelhető");
                            }
                        }

                        logger.info("új találat létrehozása");

                        talalat = new Talalat();
                    }

                    if (talalat.nemtalalt()) {
                        logger.info("a kiválasztott képek nem egyeznek");
                        teves_talalat++;
                        for (int i = 0; i < 20; i++) {
                            if (jatek.getLapIndex(i).equals(talalat.getElsoKep()) || jatek.getLapIndex(i).equals(talalat.getMasodikKep())) {

                                ((ImageView) pane.getChildren().get(i)).setImage(hatter);

                            }

                        }
                        logger.info("új találat létrehozása");

                        talalat = new Talalat();

                    }

                    ht.setText(Integer.toString(talalat_szama));
                    nht.setText(Integer.toString(teves_talalat));
                    if (ht.getText().equals("10")) {
                        logger.info("Új rekord létrehozása.");

                        rek = new Rekordok(jneve.getText(), talalat_szama, teves_talalat);
                        try {
                            logger.info("Rekord xml-be történő kiirása.");

                            jatekkontr.XMLFrissitess(rek);

                            XMLFeldolg feld = new XMLFeldolg();

                            feld.listData();
                            logger.info("Rekordok xml-ből történő kiirása.");

                            for (Rekordok r : feld.listData()) {
                                reklista.getItems().add(new RekListazasa(r.getNev(), r.getHelyesTipp(), r.getHelytelenTipp()));

                            }

                        } catch (ParserConfigurationException ex) {
                            Logger.getLogger(JatekNezetKontroller.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(JatekNezetKontroller.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SAXException ex) {
                            Logger.getLogger(JatekNezetKontroller.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (TransformerException ex) {
                            Logger.getLogger(JatekNezetKontroller.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        alert();
                    }

                }

            }

        };

    }

    public void alert() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Nyertél");
        alert.setHeaderText(null);
        alert.setContentText("Eredményed 10 helyes és " + nht.getText() + "  helytelen tipp.");
        ButtonType kilepes = new ButtonType("Kilépés");
        ButtonType uj_jatek = new ButtonType("Új játék");
        alert.getButtonTypes().setAll(kilepes, uj_jatek);
        Optional<ButtonType> eredmeny = alert.showAndWait();

        if (eredmeny.get() == kilepes) {
            logger.info("Kilepes.");

            Platform.exit();

        } else {
            logger.info("Új játék.");

            jatekkontr.start();
        }

    }

}
