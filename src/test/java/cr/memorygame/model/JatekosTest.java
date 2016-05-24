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

import cr.memorygame.model.Jatekos;
import cr.memorygame.model.Nehezseg;
import cr.memorygame.model.Temak;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roli
 */
public class JatekosTest {

    @Test
    public void JatekosEllenorzes() {
        String nev = "nev";
        Nehezseg nehezseg = Nehezseg.Közepes;
        Temak tema = Temak.virag;
        Jatekos player = new Jatekos(nev, nehezseg, tema);

        assertEquals("Helyes nev", true, player.getNev().equals("nev"));
        assertEquals("Helytelen nev", false, (!player.getNev().equals("nev")));

        assertEquals("Helyes nehezsegi fokozat", true, player.getNehezseg().equals(nehezseg));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getNehezseg().equals(nehezseg)));

        
        assertEquals("Helyes nehezsegi fokozat", true, player.getTema().equals(tema));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getTema().equals(tema)));

      
    }

    @Test
    public void JatekosEllenorzes2() {
        String nev = "nev";
        Nehezseg nehezseg = null;
        Temak tema = null;
        Jatekos player = new Jatekos(nev, nehezseg, tema);

        assertEquals("Helyes nehezsegi fokozat", true, player.getNehezseg().equals(player.nehezseg.Közepes));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getNehezseg().equals(player.nehezseg.Közepes)));

        assertEquals("Helyes nehezsegi fokozat", true, player.getTema().equals(player.tema.allat));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getTema().equals(player.tema.allat)));

    }

    @Test
    public void JatekosEllenorzes3() {

        Jatekos player = new Jatekos(null, null, null);

        player.setNev("alma");
        player.setNehezseg(Nehezseg.Nehéz);
        player.setTema(Temak.virag);

        assertEquals("Helyes nev", true, player.getNev().equals("alma"));
        assertEquals("Helytelen nev", false, (!player.getNev().equals("alma")));

        assertEquals("Helyes nehezsegi fokozat", true, player.getNehezseg().equals(player.nehezseg.Nehéz));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getNehezseg().equals(player.nehezseg.Nehéz)));

        assertEquals("Helyes nehezsegi fokozat", true, player.getTema().equals(player.tema.virag));
        assertEquals("Helytelen nehezsegi fokozat", false, (!player.getTema().equals(player.tema.virag)));

    }

}
