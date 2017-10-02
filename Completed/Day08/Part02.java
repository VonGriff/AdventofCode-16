import java.util.Scanner;
import java.util.LinkedList;
import java.lang.StringBuffer;

public class Part02 {

	private boolean[][] screen;
	private final int MAXROW = 6;
	private final int MAXCOL = 50;
	
	public Part02(boolean[][] screen) {
		this.screen = screen;
	}

	public String run() {
		StringBuffer buf = new StringBuffer();
		for (int i=0; i<MAXROW; i++) {
			for (int j=0; j<MAXCOL; j++) {
				if (screen[i][j])
					buf.append("#");
				else
					buf.append(" ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}
}