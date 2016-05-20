/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame;

import cr.memorygame.view.GameViewController;

/**
 *
 * A játékos tulajdonságait tartalmazó osztály.
 */
public class Player {

    public Nehezseg nehezseg;
    public Temak tema;
    public String temaeleres;
    public GameViewController view;
    public String name;

    /**
     * Új játékos létrehozása.
     *
     * @param name - a játékos neve
     * @param nehezseg - a választott nehézségi fokozat
     * @param tema - a választott téma
     */
    public Player(String name, Nehezseg nehezseg, Temak tema) {
        this.nehezseg = ((nehezseg != null) ? nehezseg : Nehezseg.Közepes);
        this.tema = ((tema != null) ? tema : Temak.allat);
        this.name = name;
        this.temaeleres = temaeleres;

       
    }
/**
 * 
 * @return nehezseg
 */
    public Nehezseg getNehezseg() {
        return nehezseg;
    }
/**
 * 
 * @param nehezseg - beallitasa
 */
    public void setNehezseg(Nehezseg nehezseg) {
        this.nehezseg = nehezseg;
    }
/**
 * 
 * @return tema
 */
    public Temak getTema() {
        return tema;
    }
/**
 * 
 * @param tema - beállitása
 */
    public void setTema(Temak tema) {
        this.tema = tema;
    }
/**
 * 
 * @return naem 
 */
    public String getName() {
        return name;
    }
/**
 * 
 * @return temaeleres
 */
    public String getTemaEleres() {
        return temaeleres;
    }

    /**
     * 
     * @param temaeleres - beallitasa
     */
    public void setTemaEleres(String temaeleres) {
        this.temaeleres = temaeleres;
    }
/**
 * 
 * @param view - beallitasa
 */
    public void setView(GameViewController view) {
        this.view = view;
    }

}
