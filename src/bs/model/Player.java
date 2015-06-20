package bs.model;

import java.util.ArrayList;

import bs.view.Board;


//Each player will have a board and some ships
public class Player {
	private final Board board;
	private ArrayList<Ship> ships;
	
	
	public Player() {
		this.board = new Board(this);
		this.ships = new ArrayList<>();
	}
	
	
//	public void placeShip(int shipSize) {
//	board.placeShip(shipSize);
//		
//		
//	}
	


	public Board getBoard() {
		return board;
	}
	
	public void addShip(Ship ship) {
		ships.add(ship);
	}
	
	

}
