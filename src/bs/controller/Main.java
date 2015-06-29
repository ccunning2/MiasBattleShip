package bs.controller;

import java.util.ArrayList;

import bs.model.Player;
import bs.view.PlacementBoard;
import bs.view.PlayingBoard;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.awt.ModalityEvent;

public class Main extends Application {
	
	
	private static Player one = new Player();
	private static Player two = new Player();
	private static PlacementBoard onePlaceBoard = one.getBoard();
	private static PlacementBoard twoPlaceBoard = two.getBoard();
	private static Stage primaryStage;
	private static Player current = one;
	public static Label status = new Label("Player 1 Place Your Ships");
	public static Label status2 = new Label("");
	public static Label status3 = new Label("(Click button or press space to rotate)");
	private static BorderPane root = new BorderPane(onePlaceBoard);
	public static VBox bottom = new VBox();
	private static int turn = 1;
	private static PlayingBoard onePlay = null;
	private static PlayingBoard twoPlay = null;
	public static Button rotate = new Button("Rotate");
	private static ArrayList<Integer> shipSizes = new ArrayList<>();
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		
		
		
		//Establish styles for our controls
		rotate.setStyle("-fx-font-family: Helvetica; -fx-font-size: 14;");
		status.setStyle("-fx-font-family:Helvetica; -fx-font-size: 24; -fx-font-weight: bold;");
		bottom.setStyle("-fx-background-color: linear-gradient(to top right, mediumspringgreen, darkturquoise, black);");
		bottom.setSpacing(0);
		bottom.getChildren().addAll(status,status2,status3, rotate);
		
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
		status3.setText("");

		rotate.setText("End Turn"); //Rotate button becomes end turn button
		rotate.setVisible(false); //Hide end turn button until guess is made
		
		ContinuePlay();
		
	}
	
	public static void ContinuePlay() {
		if (turn % 2 != 0){ //Player 1 turn
			root.setCenter(onePlay);
			status.setText("Player 1's turn.");
			status2.setText("Enemy ships remaining: " + two.getShips().size());
			rotate.setOnAction(e -> onePlay.endTurn());
		} else { //Player 2 turn
			root.setCenter(twoPlay);
			status.setText("Player 2's turn.");
			status2.setText("Enemy ships remaining: " + one.getShips().size());
			rotate.setOnAction(e -> twoPlay.endTurn());
		}
	}
	
	public static void incrementTurn(){
		turn++;
	}
	
	public static void gameOver(){
		Stage overStage = new Stage();
		overStage.initOwner(primaryStage);
		overStage.initModality(Modality.APPLICATION_MODAL);
		Label gameover = new Label("Game Over");
		Button exit = new Button("EXIT");
		exit.setOnAction(e -> System.exit(0));
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(gameover, exit);
		Scene scene = new Scene(root, 300,50);
		overStage.setScene(scene);
		overStage.setTitle("We have a winner! ...And a loser!");
		overStage.show();
		
	}

}
