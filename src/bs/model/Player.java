package bs.model;

import java.util.ArrayList;

import bs.view.PlacementBoard;
import bs.view.PlayingBoard;


//Each player will have a board and some ships
public class Player {
	private final PlacementBoard placementBoard;
	private final PlayingBoard playingBoard = null;
	private ArrayList<Ship> ships;
	
	
	public Player() {
		this.placementBoard = new PlacementBoard(this);
		this.ships = new ArrayList<>();
	}
	
	
//	public void placeShip(int shipSize) {
//	board.placeShip(shipSize);
//		
//		
//	}
	


	public PlacementBoard getBoard() {
		return placementBoard;
	}
	
	public void addShip(Ship ship) {
		ships.add(ship);
	}
	
	

}
