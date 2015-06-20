package bs.model;

import java.util.ArrayList;

import bs.view.BoardTile;

public class Ship {
	private boolean afloat;
	private ArrayList<BoardTile> tiles;
	
	
	public boolean isAfloat() {
		return afloat;
	}
	public void setAfloat(boolean afloat) {
		this.afloat = afloat;
	}
	
	
	
	public Ship(ArrayList<BoardTile> tiles) {
		this.tiles = tiles;
	}
	

}