package bs.view;

public class Scratch {
	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder("private BoardTile ");
		
		for (int i=0; i<100; i++) {
			sb.append("r" + i +", ");
		}
		
		System.out.print(sb.toString());
	}
	

}
