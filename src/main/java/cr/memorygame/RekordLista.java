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

import cr.memorygame.model.Rekordok;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Be nem fejezett oszataly.
 *
 */
public class RekordLista {

    public ArrayList<Rekordok> getHighScores() {
        ArrayList<Rekordok> rekordok = new ArrayList<Rekordok>();

        return null;
    }

    /**
     * Az Xmlben levo nevek visszadasara szolgal.
     * @return 
     */
    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("proba");

        return names;
    }
}
