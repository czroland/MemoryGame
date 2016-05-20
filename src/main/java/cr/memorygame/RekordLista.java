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
 *
 * @author roli
 */
public class RekordLista {
    public ArrayList<Rekordok> getHighScores() {
		ArrayList<Rekordok> rekordok = new ArrayList<Rekordok>();
		
		/*try (Connection connection = ConnectionFactory.getConnection()) {
			Statement st = connection.createStatement();
			ResultSet rset = st.executeQuery("select * from characters");

			while (rset.next()) {
				String name = rset.getString("name");
				int kills = rset.getInt("kills");
				int distance = rset.getInt("distance");
				
				highScores.add(new HighScore(name, kills, distance));
			}
		} catch (SQLException e) {
			logger.warn("Couldn't connect to the database.");
			e.printStackTrace();
		} catch (IOException e1) {
			logger.warn("Couldn't find the database properties file.");
			e1.printStackTrace();
		}
		
		return highScores;*/
                return null;
	}
     public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
                names.add("proba");
		
		/*try (Connection connection = ConnectionFactory.getConnection()) {
			Statement st = connection.createStatement();
			ResultSet rset = st.executeQuery("select * from characters");

			while (rset.next()) {
				String name = rset.getString("name");
				int kills = rset.getInt("kills");
				int distance = rset.getInt("distance");
				
				highScores.add(new HighScore(name, kills, distance));
			}
		} catch (SQLException e) {
			logger.warn("Couldn't connect to the database.");
			e.printStackTrace();
		} catch (IOException e1) {
			logger.warn("Couldn't find the database properties file.");
			e1.printStackTrace();
		}
		
		return highScores;*/
                return names;
	}
}
