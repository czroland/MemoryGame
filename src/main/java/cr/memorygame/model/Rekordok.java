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
package cr.memorygame.model;

import java.util.Date;

/**
 *
 * A rekordokat, és annak adatait tartalmazó osztály.
 */
public class Rekordok {
    String nev;
    int helyesTipp;
    int helytelenTipp;

    /**
     * 
     * @return nev
     */
    public String getNev() {
        return nev;
    }
/**
 * 
 * @return helyesTipp
 */
    public int getHelyesTipp() {
        return helyesTipp;
    }
    /**
     * 
     * @return helytelenTipp
     */

    public int getHelytelenTipp() {
        return helytelenTipp;
    }
    
    
/**
 * Az osztály constructora.
 * @param nev - a játékos neve
 * @param helyesTipp - a helyesen megadott tippek száma
 * @param helytelenTipp - a helytelenül megadott tippek száma
 */
    public Rekordok(String nev, int helyesTipp,int helytelenTipp) {
        this.nev = nev;
        this.helyesTipp = helyesTipp;
        this.helytelenTipp = helytelenTipp;
    }
    
}
