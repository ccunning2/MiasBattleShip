package bs.controller;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import bs.model.Player;
import bs.view.PlacementBoard;
import bs.view.PlayingBoard;

public class Main extends Application {
	
	
	private static Player one = new Player();
	private static Player two = new Player();
	private static PlacementBoard onePlaceBoard = one.getBoard();
	private static PlacementBoard twoPlaceBoard = two.getBoard();
	private static Stage primaryStage;
	private static Player current = one;
	private static Label status = new Label("Player 1 Place Your Ships");
	private static BorderPane root = new BorderPane(onePlaceBoard);
	private static HBox bottom = new HBox();
	private static int turn = 1;
	private static PlayingBoard onePlay = null;
	private static PlayingBoard twoPlay = null;
	private static Button rotate = new Button("Rotate");
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		ArrayList<Integer> shipSizes = new ArrayList<>();
		
		//Add a rotate button to rotate the ships
		
		
		
		bottom.setSpacing(80);
		bottom.getChildren().addAll(status, rotate);
		
		rotate.setOnAction(e -> rotate());
		
		
		//Add the sizes of ships we want to play with
		populateShips(shipSizes);
		
		
		
		
		root.setBottom(bottom);
		bottom.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Mia's Battleship!");
		primaryStage.show();
		placeShips(shipSizes);
		
		
		
		
	}

	private static void populateShips(ArrayList<Integer> shipSizes) {
		shipSizes.add(5);
		shipSizes.add(4);
		shipSizes.add(3);
		shipSizes.add(3);
		shipSizes.add(2);
	}

	private static void rotate() {
		PlacementBoard board = current.getBoard();
		board.setRotated(!board.isRotated());
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	public static void placeShips(ArrayList<Integer> shipSizes){
		if (!shipSizes.isEmpty() && current.equals(one)){
		one.getBoard().placeShip(shipSizes);
		} else if (current.equals(one)) {
			//Repopulate ships and place on player two's board
			populateShips(shipSizes);
			current = two;
			root.setCenter(twoPlaceBoard);
			status.setText("Player 2 Place Your Ships");
			two.getBoard().placeShip(shipSizes);
		} else if (!shipSizes.isEmpty() && current.equals(two)){
			two.getBoard().placeShip(shipSizes);
		} else { // We're finished placing ships
			play();
		}
	}

	private static void play() {
		//Create each player's playing board
		onePlay = new PlayingBoard(twoPlaceBoard, one);
		twoPlay = new PlayingBoard(onePlaceBoard, two);
//		bottom.getChildren().remove(rotate);
		rotate.setText("End Turn");
		
		ContinuePlay();
		
	}
	
	public static void ContinuePlay() {
		if (turn % 2 != 0){ //Player 1 turn
			root.setCenter(onePlay);
			status.setText("Player 1's turn.");
			rotate.setOnAction(e -> onePlay.endTurn());
		} else { //Player 2 turn
			root.setCenter(twoPlay);
			status.setText("Player 2's turn.");
			rotate.setOnAction(e -> twoPlay.endTurn());
		}
	}
	
	public static void incrementTurn(){
		turn++;
	}

}
