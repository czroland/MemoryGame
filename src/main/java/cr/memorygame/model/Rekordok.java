/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
