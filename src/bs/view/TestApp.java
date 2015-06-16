package bs.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bs.model.Player;

public class TestApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
//		Board test = new Board();
//		Group root = new Group(test);
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.setTitle("Testing Board");
//		primaryStage.sizeToScene();
//		primaryStage.show();
//		System.out.println("Height: " +scene.getHeight() + " Width: " + scene.getWidth());

		Player one = new Player();
		Board root = one.getBoard();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		one.placeShip(1);
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
