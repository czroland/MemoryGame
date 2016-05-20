/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import cr.memorygame.GameController;

/**
 * Az FX kezelőfelület ablakai ebből az osztályból vannak származtatva.
 */
public class ViewController {

    protected GameController game;

    /**
     * Ez a metódus teszi lehetővé a controllereknek, hogy kommunikáljanak
     * egymással.
     */
    public void setGameController(GameController game) {
        this.game = game;
    }

}
