/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
     *
     * @return elsoKep elerese
     */
    public String getElsoKep() {
        return elsoKep;
    }

    /**
     *
     * @return masodikKep elerese
     */
    public String getMasodikKep() {
        return masodikKep;
    }

    /**
     *
     * @return talalatokszama hány kepet valasztottunk ki
     */
    public int getTalalatSzama() {
        return talalatSzama;
    }

    /**
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
     * @return hamisat, amennyiben 2 képet választottunk ki, igazat, ha többet
     * akarunk
     */
    public boolean nemtalalt() {
        return nemtalalt;
    }

}
