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
 *
 * A kivalasztott képek egyezésének ellenőrzésére szolgáló osztály.
 */
public class Talalat {

    String elsoKep;
    String masodikKep;
    int talalatSzama = 0;
    boolean nemtalalt = false;
    Jatek jatek;

    /**
     * Visszaadja az elsőnek választott kép elérését.
     *
     * @return az elsoKep elérése
     */
    public String getElsoKep() {
        return elsoKep;
    }

    /**
     * Visszaadja az másodiknak választott kép elérését.
     *
     * @return a masodikKep elérése
     */
    public String getMasodikKep() {
        return masodikKep;
    }

    /**
     * Visszaadja hány képet választottunk ki.
     *
     * @return a talalatokszama hány képet valásztottunk ki
     */
    public int getTalalatSzama() {
        return talalatSzama;
    }

    /**
     * Beállitja a valasztott képeket <code>elsoKep</code>-nek és
     * <code>masodikKep</code>-nek.
     *
     * @param kep a kiválasztott kép, első választott képet megkapja elsoKep,
     * másodikat pedig masodikKep
     * @return amennyiben 2 letező kepet választottunk ki igaz értéket ad vissza
     */
    public boolean UjTalalat(String kep) {
        if (kep == elsoKep) {
            return false;
        }

        if (talalatSzama == 0) {
            elsoKep = kep;
            talalatSzama++;
            return true;
        }
        if (talalatSzama == 1) {
            masodikKep = kep;
            talalatSzama++;
            return true;
        }

        nemtalalt = true;
        return false;

    }

    /**
     * Megmodja, hogy két képet választottunk-e ki.
     *
     * @return igazat, ha két képet választottunk ki
     */
    public boolean helyesTalalat() {
        if (talalatSzama == 2) {
            return true;
        } else {
            return false;

        }

    }

    /**
     *
     * @return hamisat, amennyiben 2 képet választottunk ki, igazat, ha nem
     *
     */
    public boolean nemtalalt() {
        return nemtalalt;
    }

}
