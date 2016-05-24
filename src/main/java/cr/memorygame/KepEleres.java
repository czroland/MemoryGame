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

import java.io.File;


/**
 *
 * Ez az osztaly adja meg a képek eléresi mappáját.
 */
public final class KepEleres {

    private File kep;

    /**
     * Az osztály konstruktora.
     *
     * @param Eleres - az elérési mappa
     */
    public KepEleres(String Eleres) {
        setEleres(Eleres);
    }

    /**
     * Beállitja a kép elérését.
     *
     * @param Eleres eleresi mappa létrehozása
     */
    public void setEleres(String Eleres) {
        kep = new File(Eleres);
    }

    /**
     *
     * @param EleresMappa - beállítása
     */
    /*public void setEleres(File EleresMappa) {
     Kep = EleresMappa;
     }*/
    /**
     * Visszaadja a képek elérési mappáját.
     *
     * @return a mappa elérése
     */
    public String getEleres() {
        if (kep == null) {
            return "";
        } else {
            return kep.getPath();
        }

    }

    /**
     *
     * @return a mappa elérése File-ként
     */
    /*public File getKep() {
     return Kep;
     }*/
}
