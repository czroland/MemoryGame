/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame;

import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleConnection;

/**
 *
 * @author roli
 */
public class ConnectionFactory {
    
        private static ConnectionFactory factory = new ConnectionFactory();
 private ConnectionFactory() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
