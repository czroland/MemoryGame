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

import cr.memorygame.view.GameViewController;
import cr.memorygame.view.Main;
import java.util.ArrayList;


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
 * @param name - ellenőrzi, hogy a játékos neve szerepe-e már az adatbázisba, megfelelő számú karakterből áll-e.
 */
    public boolean joeaNev(String name) {
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
        this.view = view;
        player.setView(view);
        //map.updateMap();
    }

    /**
 * Elindítja a játékot.
 */
    public void start() {
               mainApp.jatek();
    }
}
