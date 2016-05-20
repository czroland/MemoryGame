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
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

    private Stage primaryStage;
    private GameController game;

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
            /*logger.info("Login screen set up and shown.");
             primaryStage.setOnCloseRequest((WindowEvent e)-> {
             logger.info("Quit.");
             });*/
        } catch (IOException e) {
            e.printStackTrace();
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
           //System.out.println(game.getPlayer().getName());
            /*logger.info("Login screen set up and shown.");
             primaryStage.setOnCloseRequest((WindowEvent e)-> {
             logger.info("Quit.");
             });*/
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
        launch(args);
    }

}
