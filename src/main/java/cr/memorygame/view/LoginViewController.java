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

import cr.memorygame.Nehezseg;
import cr.memorygame.Temak;
import cr.memorygame.Player;
import cr.memorygame.KepEleres;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author roli
 */
public class LoginViewController extends ViewController {

    @FXML
    private TextField name;
    @FXML
    private Label nev_hiba;

    @FXML
    private ComboBox valaszt;

    @FXML
    private ToggleGroup nehezsegtoggle;

    @FXML
    private RadioButton konnyu;
    @FXML
    private RadioButton kozepes;
    @FXML
    private RadioButton nehez;
    @FXML
    private Button button;

    @FXML
    private void check() {
        if (name.getText().length() < 3) {
            nev_hiba.setText("Túl rövid név!");
        } else {
            boolean foglalt_e = game.check(name.getText());
            if (foglalt_e) {
                nev_hiba.setText("A név foglalt!");
            } else {
                Nehezseg nehezseg = Nehezseg.Közepes;

                if (nehezsegtoggle.getSelectedToggle().equals(konnyu))
                nehezseg = Nehezseg.Könnyű;

                if (nehezsegtoggle.getSelectedToggle().equals(kozepes))
                nehezseg = Nehezseg.Közepes;

                if (nehezsegtoggle.getSelectedToggle().equals(nehez))
                nehezseg = Nehezseg.Nehéz;

                Temak tema = Temak.allat;
                if (valaszt.getValue().equals("Állat")) {
                    tema = Temak.allat;
                }
                if (valaszt.getValue().equals("Gyümölcs")) {
                    tema = Temak.gyumolcs;
                }
                if (valaszt.getValue().equals("Virág")) {
                    tema = Temak.virag;
                }
                

               // System.out.println(nehezseg);
                Player player = new Player(name.getText(), nehezseg, tema);
                KepEleres kep = new KepEleres("/img/"+valaszt.getValue().toString()+"/");

                game.initializePlayer(player);
                game.initializeKepeleres(kep);
                                /**/

                game.start();
                //System.out.println(game.getPlayer().getName());
            }

        }

    }

    @FXML
    private void quit() {
        Platform.exit();
    }

}
