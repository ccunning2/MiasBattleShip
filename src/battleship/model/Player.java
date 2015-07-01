package battleship.model;

import java.util.ArrayList;

import battleship.view.PlacementBoard;
import battleship.view.PlayingBoard;


//Each player will have a board and some ships
public class Player {
	private final PlacementBoard placementBoard;
	private final PlayingBoard playingBoard = null;
	private ArrayList<Ship> ships;
	
	
	public Player() {
		this.placementBoard = new PlacementBoard(this);
		this.ships = new ArrayList<>();
	}
	
	

	


	public ArrayList<Ship> getShips() {
		return ships;
	}






	public PlacementBoard getBoard() {
		return placementBoard;
	}
	
	public void addShip(Ship ship) {
		ships.add(ship);
	}
	
	public void sinkShip(Ship ship){
		this.ships.remove(ship);
	}
	
	

}
