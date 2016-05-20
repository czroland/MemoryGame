/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
