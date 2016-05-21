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
import cr.memorygame.GameController;
import cr.memorygame.Jatek;
import cr.memorygame.KepEleres;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.application.Platform;

import cr.memorygame.Player;
import cr.memorygame.Talalat;
import static cr.memorygame.view.Main.logger;
import java.net.URI;
import java.net.URL;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author roli
 */
public class GameViewController extends ViewController {

    private static final int CARDS_PER_ROW = 4;
    private final EventHandler imageViewClickEventHandler = clickEventHandler();
    Jatek jatek;
    Talalat talalat;
    Player player;
    @FXML
    private GridPane pane;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label jneve;

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

    int talalat_szama = 0;
    int teves_talalat = 0;
    public Image backSide = new Image(this.getClass().getResourceAsStream("/bg.jpg"));

    @Override
    public void setGameController(GameController game) {
        this.game = game;
        game.setView(this);

        adatok();
        felulet();

    }

    public String adatok() {

        jneve.setText(game.getPlayer().getName());
        nehezseg_neve.setText(game.getPlayer().getNehezseg().toString());
        tema_neve.setText(game.getPlayer().getTema().toString());

        if (game.getPlayer().getTema().toString().equals("Allat")) {
            kepeleres = "/img/allat/";

        }
        if (game.getPlayer().getTema().toString().equals("Gyümölcs")) {
            kepeleres = "/img/gyumolcs/";
        }
        if (game.getPlayer().getTema().toString().equals("Virág")) {
            kepeleres = "/img/virag/";
        }

        return kepeleres;

    }

    public void felulet() {

        for (Node gyerek : pane.getChildren()) {
            gyerek.removeEventHandler(MouseEvent.MOUSE_CLICKED, imageViewClickEventHandler);
        }
        pane.getChildren().clear();
        kep = new KepEleres(game.getKepEleres().getEleres() + "/");
        System.out.println(game.getKepEleres().getEleres() + "/");

        jatek = new Builder(kep, 10).GameBuilder();

        logger.info("ImageView -ok létrehozása");

        createImageViews(20);
        talalat = new Talalat();

    }

    private void createImageViews(int size) {
        int rowIndex = 0;
        int colIndex = 0;

        for (int cardIndex = 0; cardIndex < size; cardIndex++) {
            ImageView imageView = new ImageView(backSide);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            imageView.setEffect(new DropShadow(5, Color.BLACK));

            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, imageViewClickEventHandler);
            pane.add(imageView, rowIndex, colIndex);
            rowIndex++;
            if (rowIndex % CARDS_PER_ROW == 0) {
                colIndex++;
                rowIndex = 0;
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

                ImageView clickedImageView = (ImageView) event.getSource();

                int col = GridPane.getColumnIndex(clickedImageView);
                int row = GridPane.getRowIndex(clickedImageView);

                int selectedCardIndex = row * CARDS_PER_ROW + col;
                logger.info(jatek.getCard(selectedCardIndex) + "kép lett kiválasztva");

                //System.out.println(selectedCardIndex+"korte");
                if (talalat.UjTalalat(jatek.getCard(selectedCardIndex))) {
                    clickedImageView.setImage(new Image(jatek.getCard(selectedCardIndex)));

                }

                if (talalat.helyesTalalat()) {

                    if (jatek.talalatVan(talalat)) {
                        logger.info("a kiválasztott képek egyeznek");
                        talalat_szama++;

                        for (int i = 0; i < 20; i++) {
                            if (jatek.getCard(i).equals(talalat.getElsoKep()) && jatek.getCard(i).equals(talalat.getMasodikKep())) {
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
                            if (jatek.getCard(i).equals(talalat.getElsoKep()) || jatek.getCard(i).equals(talalat.getMasodikKep())) {

                                ((ImageView) pane.getChildren().get(i)).setImage(backSide);

                            }

                        }
                        logger.info("új találat létrehozása");

                        talalat = new Talalat();

                    }

                    ht.setText(Integer.toString(talalat_szama));
                    nht.setText(Integer.toString(teves_talalat));
                    if (ht.getText().equals("10")) {
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

            game.start();
        }

    }

}
