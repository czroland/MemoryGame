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
import static cr.memorygame.view.Main.logger;

/**
 *
 * A játékos tulajdonságait tartalmazó osztály.
 */
public class Player {

    public Nehezseg nehezseg;
    public Temak tema;
    public String temaeleres;
    public GameViewController view;
    public String name;

    /**
     * Konstruktor, amely létrehoz egy játékost reprezentáló objektumot.
     *
     * @param name a játékos neve
     * @param nehezseg a választott nehézségi fokozat
     * @param tema a választott téma
     */
    public Player(String name, Nehezseg nehezseg, Temak tema) {
        this.nehezseg = ((nehezseg != null) ? nehezseg : Nehezseg.Közepes);
        this.tema = ((tema != null) ? tema : Temak.allat);
        this.name = name;

        logger.info(name + " játékos létrehozva");
        logger.info(nehezseg + " nehézségi fokozat beallitva");
        logger.info(tema + " választott téma beállitva");

    }

    /**
     * Visszaadja a választott nehézséget.
     *
     * @return a játékos választott nehézségét
     */
    public Nehezseg getNehezseg() {
        return nehezseg;
    }

    /**
     * Beállitja a nehézséget.
     *
     * @param nehezseg beallitasa
     */
    public void setNehezseg(Nehezseg nehezseg) {
        this.nehezseg = nehezseg;
    }

    /**
     * Visszaadja a választott témát.
     *
     * @return a játékos választott témáját
     */
    public Temak getTema() {
        return tema;
    }

    /**
     * Beállitja a témát.
     *
     * @param tema beállitása
     */
    public void setTema(Temak tema) {
        this.tema = tema;
    }

    /**
     * Visszaadja a választott nevet.
     *
     * @return a választott <code>name</code> név
     */
    public String getName() {
        return name;
    }

    /**
     * Beállitja a nevet.
     *
     * @param name név beallitása
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return temaeleres
     */
    /* public String getTemaEleres() {
     return temaeleres;
     }*/
    /**
     *
     * @param temaeleres - beallitasa
     */
    /* public void setTemaEleres(String temaeleres) {
     this.temaeleres = temaeleres;
     }*/
    /**
     * Beállitja a játék nézetét.
     *
     * @param view beallitása
     */
    public void setView(GameViewController view) {
        this.view = view;
    }

}
