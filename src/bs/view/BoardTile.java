package bs.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class BoardTile extends Rectangle {
	
	//Integers to represent location in seascape (within Board class)
	//to aid in ship placement
	
	private int arrayX;
	private int arrayY;
	
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
		
		
//		EventHandler<MouseEvent> MouseHandle = e -> this.setFill(Color.RED);
		//Lets play with events
//		this.addEventHandler(MouseEvent.MOUSE_ENTERED, MouseHandle);
		
		
	}
	
	
	public void makeRed() {
		this.setFill(Color.RED);
	}
	
	

}
