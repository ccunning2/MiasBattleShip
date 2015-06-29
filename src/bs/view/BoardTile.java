package bs.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class BoardTile extends Rectangle {
	
	//Integers to represent location in seascape (within Board class)
	//to aid in ship placement
	
	private int arrayX;
	private int arrayY;
	
	//Boolean to represent whether tile is part of ship
	private boolean shipPiece = false;
	
	public int getArrayX() {
		return arrayX;
	}


	public void setArrayX(int arrayX) {
		this.arrayX = arrayX;
	}


	public int getArrayY() {
		return arrayY;
	}


	public void setArrayY(int arrayY) {
		this.arrayY = arrayY;
	}


	public BoardTile(int x, int y) {
		super(50,50,Color.TRANSPARENT);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(2);
		this.setArrayX(x);
		this.setArrayY(y);
		
		

		
		
	}


	public boolean isShip() {
		return shipPiece;
	}


	public void setShipPiece(boolean ship) {
		this.shipPiece = ship;
	}
	
	
	
	
	

}
