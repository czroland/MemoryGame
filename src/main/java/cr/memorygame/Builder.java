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

import static cr.memorygame.view.Main.logger;

/**
 * Ez az osztály állítja be a játék paramétereit.
 */
public class Builder {

    private KepEleres kepeleres;
    private int parok_szama;

    /**
     * A Builder osztály konstruktora, amely létrehoz egy objektumot.
     *
     * @param kepeleres a választott témához tartozó képek elérési mappája.
     * @param parok_szama a játékban használt képek száma.
     */
    public Builder(KepEleres kepeleres, int parok_szama) {
        this.kepeleres = kepeleres;
        this.parok_szama = parok_szama;
        logger.info(kepeleres.getEleres() + "/ képelérési mappa");
        logger.info(parok_szama + " pár kép inicializálva");

    }

    /**
     * Visszaadja a Builder képelérési mappáját.
     *
     * @return a kepeleres
     */
    public KepEleres getKepeleres() {
        return kepeleres;
    }

    /**
     * Visszaadja a Builderben felhasznált képpárok számát.
     *
     * @return a parok_szama
     */
    public int getParok_szama() {
        return parok_szama;
    }

    /**
     * Létrehoz egy új Jatek-ot a megadott paraméterekkel.
     *
     * @return egy új Jatek a megadott paraméterekkel
     */
    public Jatek GameBuilder() {
        logger.info("Új játék létrehozva");

        return new Jatek(this.kepeleres, this.parok_szama);

    }

}
