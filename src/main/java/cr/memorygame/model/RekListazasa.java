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

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * a tableview feltoltesere letrehozott osztaly
 */
public class RekListazasa {

    private final SimpleStringProperty nev;
    private final SimpleIntegerProperty helyes;
    private final SimpleIntegerProperty helytelen;

    /**
     * az osztaly constructora
     *
     * @param nev a jatekosok neve, mely az xmlben van
     * @param helyes a jatekos helyes tippjeinek szama
     * @param helytelen a jatekos helytelen tippjeinek szama
     */
    public RekListazasa(String nev, int helyes, int helytelen) {
        this.nev = new SimpleStringProperty(nev);
        this.helyes = new SimpleIntegerProperty(helyes);
        this.helytelen = new SimpleIntegerProperty(helytelen);
    }

    /**
     * szep dolog, hogy a getter neve Propertyre kell vegzodjon, maskepp
     * formazatlan data-t add vissza
     *
     * @return nev
     */
    public SimpleStringProperty nevProperty() {
        return nev;
    }

    /**
     * szep dolog, hogy a getter neve Propertyre kell vegzodjon, maskepp
     * formazatlan data-t add vissza
     *
     * @return helyes
     */

    public SimpleIntegerProperty helyesProperty() {
        return helyes;
    }

    /**
     * szep dolog, hogy a getter neve Propertyre kell vegzodjon, maskepp
     * formazatlan data-t add vissza
     *
     * @return helytelen
     */
    public SimpleIntegerProperty helytelenProperty() {
        return helytelen;
    }

}
