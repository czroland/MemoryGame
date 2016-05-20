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

/**
 * Ez az osztály állítja be a játék paramétereit.
 */
public class Builder {

    private KepEleres kepeleres;
    private int parok_szama;
/**
 * A Builder osztály constructora.
 * @param kepeleres - a választott témához tartozó képek elérési mappája.
 * @param parok_szama - a játékban használt képek száma.
 */
    public Builder(KepEleres kepeleres, int parok_szama) {
        this.kepeleres = kepeleres;
        this.parok_szama = parok_szama;
    }

    
/**
 * @return kepeleres
 */
    public KepEleres getKepeleres() {
        return kepeleres;
    }
 /**
 * @return parok_szama
 */
    public int getParok_szama() {
        return parok_szama;
    }

   /**
 * @return Jatek a megadott paraméterekkel
 */
    public Jatek GameBuilder()
    {
    return new Jatek(this.kepeleres,this.parok_szama);
    }
    
    
}
