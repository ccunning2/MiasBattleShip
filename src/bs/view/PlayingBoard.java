package bs.view;

import bs.controller.Main;
import bs.model.Player;
import bs.model.Ship;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class PlayingBoard extends TilePane {
	
	private BoardTile[][] seaScape;
	private Player player;
	
	//Each player's playing board should be populated with the data from the opposite player's placement board
	
	public PlayingBoard(PlacementBoard board, Player player) {
		super();
		this.setPrefColumns(10);
		this.setTileAlignment(Pos.CENTER);
		this.seaScape = board.getSeaScape();
		this.player = player;
		//Clear all tiles
		for (int i=0; i<10; i++){ //Instantiate each tile and add to Board
			for (int j=0; j<10; j++){
				seaScape[i][j].setFill(Color.TRANSPARENT);
				seaScape[i][j].setOnMouseClicked(e -> guess(e));
				seaScape[i][j].setOnMouseExited(null);
				seaScape[i][j].setOnMouseEntered(null);
				this.getChildren().add(seaScape[i][j]);
			}
		}
		this.setStyle("-fx-background-image: url('Resources/images/ship.jpg');");
		
	}

	private void guess(MouseEvent e) {
		BoardTile guess = (BoardTile) e.getSource();
		if (guess.isShip()){ //Hit
			guess.setFill(Color.RED);
			Ship hitShip = guess.getShip();
			hitShip.hit(guess);
			Main.status3.setTextFill(Color.BEIGE);
			Main.status3.setText("Hit!");
			Main.bottom.setStyle("-fx-background-color: linear-gradient(to top right, red, crimson, black);");
			//If the ship has been sunk...
			if(!hitShip.isAfloat()){
				Main.status3.setText("Ship Down!");
				hitShip.getOwner().sinkShip(hitShip);
				Main.status2.setText("Enemy ships remining: " + hitShip.getOwner().getShips().size());
				if (hitShip.getOwner().getShips().isEmpty()){
					Main.gameOver();
				}
			}
			removeListeners();
			
		} else { //Miss
			guess.setFill(Color.YELLOW);
			removeListeners();
			Main.status3.setTextFill(Color.YELLOW);
			Main.status3.setText("Miss!");
		}
		Main.rotate.setVisible(true);
	}
	
	private void removeListeners(){
		for (int i=0; i<10; i++){ //Instantiate each tile and add to Board
			for (int j=0; j<10; j++){
				seaScape[i][j].setOnMouseClicked(null);
				seaScape[i][j].setOnMouseExited(null);
				seaScape[i][j].setOnMouseEntered(null);
			}
		}
	}
	
	public void endTurn() {
		Main.incrementTurn();
		addClickListeners();
		Main.rotate.setVisible(false);
		Main.status3.setText("");
		Main.bottom.setStyle("-fx-background-color: linear-gradient(to top right, mediumspringgreen, darkturquoise, black);");
		Main.ContinuePlay();
	}
	
	private void addClickListeners() {
		for (int i=0; i<10; i++){ 
			for (int j=0; j<10; j++){
				seaScape[i][j].setOnMouseClicked(e -> guess(e));
			}
		}
	}

}
