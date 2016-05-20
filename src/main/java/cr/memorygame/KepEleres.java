/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * Ez az osztaly adja meg a kepek eleresi mappáját.
 */
public final class KepEleres {

    private File Kep;

    /**
     * Az osztály constructora.
     *
     * @param Eleres - az elérési mappa
     */
    public KepEleres(String Eleres) {
        setEleres(Eleres);
    }

    /**
     *
     * @param Eleres eleresi mappa létrehozása
     */
    public void setEleres(String Eleres) {
        Kep = new File(Eleres);
    }

    /**
     *
     * @param EleresMappa - beállítása
     */
    public void setEleres(File EleresMappa) {
        Kep = EleresMappa;
    }

    /**
     *
     * @return a mappa elérése
     */
    public String getEleres() {
        if (Kep == null) {
            return "";
        } else {
            return Kep.getPath();
        }

    }

    /**
     *
     * @return a mappa elérése File-ként
     */
    public File getKep() {
        return Kep;
    }
}
