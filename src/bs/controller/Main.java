package bs.controller;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import bs.model.Player;
import bs.view.Board;

public class Main extends Application {

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
		ArrayList<Integer> shipSizes = new ArrayList<>();
		shipSizes.add(5);
		shipSizes.add(4);
		shipSizes.add(3);
		shipSizes.add(3);
		shipSizes.add(2);
		BorderPane root = new BorderPane(oneBoard);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		placeShips(one, shipSizes);
		
		
		
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public static void placeShips(Player player, ArrayList<Integer> shipSizes){
		//TODO If shipSizes is empty...
		player.getBoard().placeShip(shipSizes);
	}

}
