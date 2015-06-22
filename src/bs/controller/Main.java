package bs.controller;

import java.util.ArrayList;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import bs.model.Player;
import bs.view.Board;

public class Main extends Application {
	
	
	Player one = new Player();
	Player two = new Player();
	Board onePlaceBoard = one.getBoard();
	Board twoPLaceBoard = two.getBoard();
	Stage primaryStage;
	Player current = one;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		ArrayList<Integer> shipSizes = new ArrayList<>();
		
		//Add a rotate button to rotate the ships
		HBox bottom = new HBox();
		Button rotate = new Button("Rotate");
		Label status = new Label("Player 1 Place Your Ships");
		bottom.setSpacing(80);
		bottom.getChildren().addAll(status, rotate);
		
		rotate.setOnAction(e -> rotate(onePlaceBoard));
		
		
		//Add the sizes of ships we want to play with
		shipSizes.add(5);
		shipSizes.add(4);
		shipSizes.add(3);
		shipSizes.add(3);
		shipSizes.add(2);
		
		//TODO Skin the App/rotate button with CSS
		
		BorderPane root = new BorderPane(onePlaceBoard);
		root.setBottom(bottom);
		bottom.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		placeShips(one, shipSizes);
		
		
		
		
	}

	private static void rotate(Board board) {
		//Toggles rotation property during ship placement
		board.setRotated(!board.isRotated());
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public static void placeShips(Player player, ArrayList<Integer> shipSizes){
		if (!shipSizes.isEmpty()){
		player.getBoard().placeShip(shipSizes);
		} else {
			
		}
	}

}
