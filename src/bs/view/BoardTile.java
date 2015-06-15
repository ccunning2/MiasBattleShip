package bs.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class BoardTile extends Rectangle {
	
	public BoardTile() {
		super(50,50,Color.TRANSPARENT);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(2);
	}

}
