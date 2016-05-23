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
package cr.memorygame.view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;

import cr.memorygame.GameController;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {

    private Stage primaryStage;
    private GameController game;
     public static Logger logger = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MemoryGame");
        belepes();
    }

    /**
     * Megjelenti a bejelentkező ablakot.
     */
    public void belepes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/fxml/belepes.fxml"));
            AnchorPane loginLayout = loader.load();

            LoginViewController controller = loader.getController();
            game = new GameController(this);
            controller.setGameController(game);

            Scene scene = new Scene(loginLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.show();
            logger.info("Bejelentkezési felület.");
            primaryStage.setOnCloseRequest((WindowEvent)-> {
            	logger.info("Kilépés.");
            });
             
   
        } catch (IOException e) {
        }

    }

    /**
	 * Megjeleníti a játék kezelőfelületét.
	 */
    public void jatek() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/fxml/jatek.fxml"));
            AnchorPane gamelayout = loader.load();

            GameViewController controller = loader.getController();
            controller.setGameController(game);

            Scene scene = new Scene(gamelayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();

            primaryStage.show();
            logger.info("Játékfelület.");
            
            primaryStage.setOnCloseRequest((WindowEvent e)-> {
            	logger.info("Kilépés.");
            });
             
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        logger.info("A program elindult.");
        launch(args);
    }

}
