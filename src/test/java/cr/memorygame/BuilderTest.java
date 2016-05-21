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

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roli
 */
public class BuilderTest {

    @Test
    public void BuilderTest() {
        KepEleres kep = new KepEleres("/img/alma");
        int lapok_szama = 124;
        Builder builder = new Builder(kep, lapok_szama);

        assertEquals("Helyes eleres", true, builder.getKepeleres().getEleres().equals("/img/alma"));
        assertEquals("Helytelen eleres", false, (!builder.getKepeleres().getEleres().equals("/img/alma")));

        assertEquals("Helyes eleres", true, builder.getParok_szama() == 124);
        assertEquals("Helyes eleres", false, builder.getParok_szama() != 124);

    }

    @Test
    public void BuilderTest2() {
        KepEleres kep = new KepEleres("/img/alma");
        int lapok_szama = 124;
        Builder builder = new Builder(kep, lapok_szama);

        builder.getKepeleres().setEleres("/img");

        assertEquals("Helyes eleres", true, builder.getKepeleres().getEleres().equals("/img"));
        assertEquals("Helytelen eleres", false, (!builder.getKepeleres().getEleres().equals("/img")));

        File Kep = new File("alma");
        builder.getKepeleres().setEleres(Kep.getPath());

        assertEquals("Helyes eleres", true, builder.getKepeleres().getEleres().equals("alma"));
        assertEquals("Helytelen eleres", false, (!builder.getKepeleres().getEleres().equals("alma")));

    }

}
