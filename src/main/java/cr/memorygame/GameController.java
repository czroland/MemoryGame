package cr.memorygame;

import cr.memorygame.view.GameViewController;
import cr.memorygame.view.Main;
import static cr.memorygame.view.Main.logger;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * A fő controller osztály.
 */
public class GameController {

    private GameViewController view;
    private Main mainApp;
    private Player player;
    public KepEleres kep;

    /**
     * @param mainApp - hivatkozik a {@link cr.memorygame.view.Main} osztályra
     */
    public GameController(Main mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * @return a player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param kep - a {@link cr.memorygame.Temak} -ból választottnak megfelelően
     * beállítja a mappát.
     */
    public void initializeKepeleres(KepEleres kep) {
        this.kep = kep;
        kep.setEleres("/img/" + player.getTema() + "/");
    }

    /**
     * @return kep
     */
    public KepEleres getKepEleres() {
        return kep;
    }

    /**
     * @param player - inicializálja a játékost.
     */
    public void initializePlayer(Player player) {
        this.player = player;
    }

    /**
     * @param name - ellenőrzi, hogy a játékos neve szerepe-e már az
     * adatbázisba, megfelelő számú karakterből áll-e.
     */
    public boolean check(String name) {
        logger.info(name + " név ellenőrzése");

        ArrayList<String> names = new RekordLista().getNames();

        if (names.contains(name)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param view - referencia a view controllerre
     */
    public void setView(GameViewController view) {
        logger.info(" nézet beállítása");

        this.view = view;
        player.setView(view);
    }

    /**
     * Elindítja a játékot.
     */
    public void start() {
        mainApp.jatek();
    }
}
