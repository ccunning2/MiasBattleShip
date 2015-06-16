package bs.view;


import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
/**
 * Creates a board. Size is 520x520
 * @author cameroncunning1
 *
 */
public class Board extends TilePane {
	//100 tiles on a board
	private BoardTile r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99;
	
	private BoardTile[][] seaScape = new BoardTile[][]{
			{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9},
			{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19},
			{r20, r21, r22, r23, r24, r25, r26, r27, r28, r29},
			{r30, r31, r32, r33, r34, r35, r36, r37, r38, r39},
			{r40, r41, r42, r43, r44, r45, r46, r47, r48, r49},
			{r50, r51, r52, r53, r54, r55, r56, r57, r58, r59},
			{r60, r61, r62, r63, r64, r65, r66, r67, r68, r69},
			{r70, r71, r72, r73, r74, r75, r76, r77, r78, r79},
			{r80, r81, r82, r83, r84, r85, r86, r87, r88, r89},
			{r90, r91, r92, r93, r94, r95, r96, r97, r98, r99}};
	
	
	public Board() {
		super();
		this.setPrefColumns(10);
		this.setTileAlignment(Pos.CENTER);
		for (int i=0; i<10; i++){ //Instantiate each tile and add to Board
			for (int j=0; j<10; j++){
				seaScape[i][j] = new BoardTile(i,j);
				this.getChildren().add(seaScape[i][j]);
			}
		}
		
	}
	
	public void placeShip() {
		//Need to get current BoardTile on mouse over
		for (BoardTile[] b : seaScape){
			for (BoardTile c : b) {
				c.setOnMouseEntered(e -> mouseInPlacingShips(e));
				c.setOnMouseExited(e -> mouseOutPlacingShips(e));
			}
		}
		
		
		}

	private void mouseOutPlacingShips(MouseEvent e) {
		BoardTile current = (BoardTile) e.getSource();
		current.setFill(Color.TRANSPARENT);
	}

	private void mouseInPlacingShips(MouseEvent e) {
		BoardTile current = (BoardTile) e.getSource();
		current.setFill(Color.SPRINGGREEN);
		System.out.println("X: " + current.getArrayX() + "Y: " + current.getArrayY());
	}
	
	
	/**
	 * Just for fun!
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	

}
