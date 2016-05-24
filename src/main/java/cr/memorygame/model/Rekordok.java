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

import java.util.Comparator;

/**
 *
 * A rekordokat, és annak adatait tartalmazó osztály.
 */
public class Rekordok {

    private String nev;
    private int helyesTipp;
    private int helytelenTipp;

    /**
     * Konstruktor, mely egy <code>Rekordok</code> -at reprezentáló objektumot
     * hoz létre.
     *
     * @param nev a játékos neve
     * @param helyesTipp a helyesen megadott tippek száma
     * @param helytelenTipp a helytelenül megadott tippek száma
     */
    public Rekordok(String nev, int helyesTipp, int helytelenTipp) {
        this.nev = nev;
        this.helyesTipp = helyesTipp;
        this.helytelenTipp = helytelenTipp;
    }

    /**
     * Visszaadja a játékos nevét.
     *
     * @return a játékos neve
     */
    public String getNev() {
        return nev;
    }

    /**
     * Visszaadja a helyes tippek számát.
     *
     * @return a helyesTipp-ek száma
     */
    public int getHelyesTipp() {
        return helyesTipp;
    }

    /**
     * Visszaadja a helytelen tippek számát.
     *
     * @return a helytelenTipp-ek száma
     */
    public int getHelytelenTipp() {
        return helytelenTipp;
    }

    /**
     * Beállitja a játékos nevét.
     *
     * @param nev a játékos neve
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Beállitja a játékos helyes tippeinek számát.
     *
     * @param helyesTipp a helzes tippek száma
     */
    public void setHelyesTipp(int helyesTipp) {
        this.helyesTipp = helyesTipp;
    }

    /**
     * Beállitja a játékos helytelen tippeinek számát.
     *
     * @param helytelenTipp a helytelen tippek száma
     */
    public void setHelytelenTipp(int helytelenTipp) {
        this.helytelenTipp = helytelenTipp;
    }

    public static Comparator<Rekordok> rendez = new Comparator<Rekordok>() {

        public int compare(Rekordok t1, Rekordok t2) {

            int rek1 = t1.getHelytelenTipp();
            int rek2 = t2.getHelytelenTipp();

            return rek1 - rek2;
        }
    };

}
