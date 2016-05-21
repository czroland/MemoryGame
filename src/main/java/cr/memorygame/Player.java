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
     * Új játékos létrehozása.
     *
     * @param name - a játékos neve
     * @param nehezseg - a választott nehézségi fokozat
     * @param tema - a választott téma
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
     *
     * @return nehezseg
     */
    public Nehezseg getNehezseg() {
        return nehezseg;
    }

    /**
     *
     * @param nehezseg - beallitasa
     */
    public void setNehezseg(Nehezseg nehezseg) {
        this.nehezseg = nehezseg;
    }

    /**
     *
     * @return tema
     */
    public Temak getTema() {
        return tema;
    }

    /**
     *
     * @param tema - beállitása
     */
    public void setTema(Temak tema) {
        this.tema = tema;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name - beallitasa
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
     *
     * @param view - beallitasa
     */
    public void setView(GameViewController view) {
        this.view = view;
    }

}
