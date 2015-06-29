package bs.model;

import java.util.ArrayList;

import bs.view.BoardTile;

public class Ship {
	private boolean afloat;
	private ArrayList<BoardTile> tiles; 
	private Player owner;

	
	
	public Player getOwner() {
		return owner;
	}
	public boolean isAfloat() {
		//Check status of all tiles
	if (tiles.isEmpty()){
		this.afloat = false;
	}
		return afloat;
	}
	public void setAfloat(boolean afloat) {
		this.afloat = afloat;
	}
	
	
	
	public Ship(ArrayList<BoardTile> tiles, Player owner) throws ShipCreationException {
		
		for(BoardTile t: tiles){
			if (t.isShip()){
				throw new ShipCreationException();
			}
		}
		for(BoardTile t: tiles){
			t.setShipPiece(true);
			t.setShip(this); //Add ship reference for status updates to player
		}
		this.tiles = tiles;
		this.afloat = true;
		this.owner = owner;
	}
	
	public void hit(BoardTile tile){
		tiles.remove(tile);
	}
	

}
