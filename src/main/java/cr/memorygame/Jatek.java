/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame;

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
        System.out.print("lapokletrehozasa jatekban");
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
            lapok.add(kep.getEleres() + "/" + i + ".jpg");
            lapok.add(kep.getEleres() + "/" + i + ".jpg");
            parok++;
            //System.out.println(parok);
            // System.out.println(lapok.get(i) +i+"lap");
            if (parok == parok_szama) {
                break;
            }

        }

        Collections.shuffle(lapok);
        System.out.println(parok);
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
                System.out.print(lapok.get(i) + "-----");
                System.out.print(talalat.elsoKep + "------");
                System.out.println(talalat.masodikKep);

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
