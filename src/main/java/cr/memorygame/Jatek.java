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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

/**
 * {@link cr.memorygame.Builder} -t használva létrehozza a Játk egy példányát.
 */
public final class Jatek {

    public List<String> lapok = new ArrayList<>();
/**
 * A Jatek osztály constructora.
 * @param kep - a választott témához tartozó képek elérési mappája.
 * @param parok_szama - a játékban használt képek száma.
 */
    public Jatek(KepEleres kep, int parok_szama) {
        lapokLetrehozasa(kep, parok_szama);
    }
/**
 * @param lapok - lapok beállítása
 */
    public void setLapok(List<String> lapok) {
        this.lapok = lapok;
    }

/**
 * Lapok létrehozása a paraméterek szerint.
 * @param kep - a kiválasztott téma képeinek elérése
 * @param parok_szama - képek száma
 */
    public void lapokLetrehozasa(KepEleres kep, int parok_szama) {
        int parok = 0;

        for (int i = 1; i < 11; i++) {
                    logger.info(kep.getEleres() + "/" + i + ".jpg lap hozzáadása a listához");

            lapok.add(kep.getEleres() + "/" + i + ".jpg");
            lapok.add(kep.getEleres() + "/" + i + ".jpg");
            parok++;
           
            if (parok == parok_szama) {
                break;
            }

        }

        Collections.shuffle(lapok);
    }

/**
 * Visszaadja, hogy a két kép megegyezik-e.
 * @param talalat - {@link cr.memorygame.Talalat} egy példánya.
 * @return a - igaz, ha egyezik a két kép;
 */
    public boolean talalatVan(Talalat talalat) {
        Boolean a = false;
        if (talalat.getTalalatSzama() < 2) {
            return false;
        }
        for (int i = 0; i < 20; i++) {
            if (lapok.get(i).equals(talalat.elsoKep) && lapok.get(i).equals(talalat.masodikKep)) {
                


                a = true;
            }
        }
        return a;
    }
/**
    @return lapok
    */
    public List<String> getLapok() {
        return lapok;
    }
/**
 * 
 * @param index - a kezelőfelületen kiválasztott kép indexe
 * @return az adott index-ű kép a lapok listából
 */
    public String getCard(int index) {
        return lapok.get(index);
    }

}
