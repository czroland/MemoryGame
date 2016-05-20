/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
