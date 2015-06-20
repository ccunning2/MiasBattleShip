package bs.model;

import bs.view.Board;


//Each player will have a board and some ships
public class Player {
	private final Board board;
	
	
	public Player() {
		this.board = new Board();
	}
	
	
	public void placeShip(int shipSize) {
	board.placeShip(shipSize);
		
		
	}
	


	public Board getBoard() {
		return board;
	}

}
