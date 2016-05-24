/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame.model;

import cr.memorygame.KepEleres;
import cr.memorygame.model.Talalat;
import cr.memorygame.model.Jatek;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roli
 */
public class JatekTest {

   

  
    @Test
    public void JatekTest() {
        KepEleres kep = new KepEleres("img");
        Jatek jatek = new Jatek(kep, 2);
        List<String> lapok = new ArrayList<>();
        int i;
        jatek.lapokLetrehozasa(kep, 2);
        for (i = 1; i < 3; i++) {
            lapok.add(kep.getEleres() + i + "/");
            lapok.add(kep.getEleres() + i + "/");
            assertEquals(i * 2, lapok.size());

        }

        assertEquals(4, lapok.size());
        assertEquals(3, i);

        jatek.setLapok(lapok);
        assertEquals(lapok, jatek.getLapok());

        Talalat talalat = new Talalat();

        talalat.UjTalalat(lapok.get(1));
        assertEquals(1, talalat.getTalalatSzama());
        assertEquals(false, jatek.talalatVan(talalat));

        talalat.UjTalalat(lapok.get(1));
        assertEquals(1, talalat.getTalalatSzama());
        assertEquals(false, jatek.talalatVan(talalat));

        assertEquals(lapok.get(1), talalat.elsoKep);
        assertEquals(null, talalat.masodikKep);

        assertEquals(jatek.getLapIndex(1), lapok.get(1));
        assertEquals(jatek.getLapIndex(1), talalat.getElsoKep());
        assertEquals(null, talalat.getMasodikKep());

        assertEquals(false, talalat.helyesTalalat());
        assertEquals(false, talalat.nemtalalt());

    }

    

}
