package bs.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import bs.model.Player;
import bs.view.Board;

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
		Board oneBoard = one.getBoard();
		BorderPane root = new BorderPane(oneBoard);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		int[] shipSizes = {5,4,3,3,2};
		one.placeShip(2);
		
		
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
