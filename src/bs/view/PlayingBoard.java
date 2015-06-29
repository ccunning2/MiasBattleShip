package bs.view;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import bs.controller.Main;
import bs.model.Player;

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
		this.setStyle("-fx-background-image: url('resources/images/ship.jpg');");
		
	}

	private void guess(MouseEvent e) {
		BoardTile guess = (BoardTile) e.getSource();
		if (guess.isShip()){
			guess.setFill(Color.RED);
			removeListeners();
			
		} else {
			guess.setFill(Color.YELLOW);
			removeListeners();
		}
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
		Main.ContinuePlay();
	}
	
	private void addClickListeners() {
		for (int i=0; i<10; i++){ //Instantiate each tile and add to Board
			for (int j=0; j<10; j++){
				seaScape[i][j].setOnMouseClicked(e -> guess(e));
			}
		}
	}

}
